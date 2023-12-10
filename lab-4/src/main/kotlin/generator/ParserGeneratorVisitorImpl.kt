package generator

import antlrgenerated.ParserGeneratorBaseVisitor
import antlrgenerated.ParserGeneratorParser
import org.antlr.v4.runtime.tree.ParseTree

class ParserGeneratorVisitorImpl : ParserGeneratorBaseVisitor<Unit>() {
    val data by lazy { VisitorData(rules, tokens, first, follow, packageName) }
    private val rules = hashMapOf<String, MutableList<MutableList<String>>>()
    private val tokens = hashMapOf<String, String>()
    private val first = hashMapOf<String, HashSet<String>>()
    private val follow = hashMapOf<String, HashSet<String>>()
    private var packageName = ""

    override fun visit(tree: ParseTree?) {
        super.visit(tree)
    }

    override fun visitPackage(ctx: ParserGeneratorParser.PackageContext?) {
        ctx ?: return
        packageName = ctx.RULE_NAME().text
    }

    override fun visitStart(ctx: ParserGeneratorParser.StartContext?) {
        ctx ?: return
        ctx.package_()?.let { visit(it) }
        ctx.rule_().forEach { visit(it) }
        ctx.token().forEach { visit(it) }
        buildFirst()
        buildFollow()
    }

    override fun visitRule(ctx: ParserGeneratorParser.RuleContext?) {
        ctx ?: return
        val ruleName = ctx.RULE_NAME().text
        val rule = mutableListOf<String>()
        ctx.rule_body().children.forEach { rule += it.text }
        rules.putIfAbsent(ruleName, ArrayList())
        rules.computeIfPresent(ruleName) { _, list ->
            list += rule
            list
        }
    }

    override fun visitToken(ctx: ParserGeneratorParser.TokenContext?) {
        ctx ?: return
        val tokenName = ctx.TOKEN_NAME().text
        val token = ctx.TOKEN_VALUE()
            ?.text
            ?.removePrefix("\"")
            ?.removeSuffix("\"")
            ?: ctx.REGEX_VALUE().text
        tokens[tokenName] = token
    }

    private fun getFirst(s: String?) = when (s) {
        in tokens -> hashSetOf(s)
        in first -> first.getOrDefault(s, hashSetOf()).toHashSet()
        else -> hashSetOf()
    }

    private fun getFollow(s: String) = when (s) {
        in follow -> follow.getOrDefault(s, hashSetOf()).toHashSet()
        else -> hashSetOf()
    }

    private fun buildFirst() {
        rules.keys.forEach { first[it] = hashSetOf() }

        var changed = true
        while (changed) {
            changed = false
            rules.keys.forEach { key ->
                rules.getOrDefault(key, emptyList()).forEach { rule ->
                    val firstItem = getFirst(rule.firstOrNull())
                    changed = first.getOrDefault(key, mutableListOf()).addAll(firstItem) or changed
                }
            }
        }
    }

    private fun buildFollow() {
        rules.keys.forEach { follow[it] = hashSetOf() }
        follow[START] = hashSetOf(EOF)

        var changed = true
        while (changed) {
            changed = false
            rules.keys.forEach { key ->
                rules.getOrDefault(key, emptyList()).forEach { rule ->
                    for (i in rule.indices) {
                        val currentRule = rule.getOrNull(i) ?: continue
                        if (currentRule !in rules) continue
                        if (i < rule.size - 1) {
                            val nextRule = rule.getOrNull(i + 1) ?: continue
                            val nextFirst = getFirst(nextRule)
                            if (nextFirst.contains(EPS)) {
                                nextFirst.remove(EPS)
                                changed = follow.getOrDefault(currentRule, mutableListOf())
                                    .addAll(getFollow(nextRule)) or changed
                            }
                            changed = follow.getOrDefault(currentRule, mutableListOf()).addAll(nextFirst) or changed
                        } else {
                            changed =
                                follow.getOrDefault(currentRule, mutableListOf()).addAll(getFollow(key)) or changed
                        }
                    }
                }
            }
        }
    }

    private companion object {
        const val START = "start"
        const val EOF = "EOF"
        const val EPS = "EPS"
    }
}