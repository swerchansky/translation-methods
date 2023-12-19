package generator

import antlrgenerated.ParserGeneratorBaseVisitor
import antlrgenerated.ParserGeneratorParser
import generator.Constants.ATTR_SYMBOL
import generator.Constants.EOF
import generator.Constants.EPS
import generator.Constants.START
import org.antlr.v4.runtime.tree.ParseTree

class ParserGeneratorVisitorImpl : ParserGeneratorBaseVisitor<Unit>() {
    val data by lazy {
        VisitorData(
            rules,
            tokens,
            first,
            follow,
            packageName,
            ruleNumberFromFirst,
            nodeValues,
            attributes
        )
    }
    private val rules = hashMapOf<String, MutableList<MutableList<String>>>()
    private val tokens = linkedMapOf<String, String>()
    private val first = hashMapOf<String, HashSet<String>>()
    private val follow = hashMapOf<String, HashSet<String>>()
    private val ruleNumberFromFirst = hashMapOf<String, HashMap<String, Int>>()
    private val nodeValues = mutableListOf<String>()
    private val attributes = mutableListOf<String>()
    private var packageName = ""

    override fun visit(tree: ParseTree?) {
        super.visit(tree)
    }

    override fun visitPackage(ctx: ParserGeneratorParser.PackageContext?) {
        ctx ?: return
        packageName = ctx.PACKAGE_NAME().text
    }

    override fun visitParserAttr(ctx: ParserGeneratorParser.ParserAttrContext?) {
        super.visitParserAttr(ctx)
        ctx ?: return
        attributes.add(ctx.ATTR().text)
    }

    override fun visitNodeValue(ctx: ParserGeneratorParser.NodeValueContext?) {
        ctx ?: return
        nodeValues.add(ctx.ATTR().text)
    }

    override fun visitStart(ctx: ParserGeneratorParser.StartContext?) {
        ctx ?: return
        tokens[EPS] = EPS
        tokens[EOF] = EOF
        ctx.children.forEach { visit(it) }
        buildFirst()
        buildFollow()
        buildRuleNumberFromFirst()
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
                        if (currentRule !in rules || currentRule.startsWith(ATTR_SYMBOL)) continue
                        if (i < rule.size - 1) {
                            var position = i + 1
                            while (position < rule.size && rule[position].startsWith(ATTR_SYMBOL)) position++
                            if (position >= rule.size) {
                                changed = follow.getOrDefault(currentRule, mutableListOf())
                                    .addAll(getFollow(key)) or changed
                                continue
                            }
                            val nextFirst = getFirst(rule[position])
                            if (nextFirst.contains(EPS)) {
                                nextFirst.remove(EPS)
                                changed = follow.getOrDefault(currentRule, mutableListOf())
                                    .addAll(getFollow(rule[position])) or changed
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

    private fun buildRuleNumberFromFirst() {
        first.keys.forEach { ruleName ->
            ruleNumberFromFirst[ruleName] = hashMapOf()
            first.getOrDefault(ruleName, hashSetOf()).forEach { firstElement ->
                rules.getOrDefault(ruleName, emptyList()).forEachIndexed { index, rule ->
                    if (firstElement in getFirst(rule.first())) {
                        val tokenToRule = ruleNumberFromFirst.getOrDefault(ruleName, mutableMapOf())
                        tokenToRule[firstElement] = index
                    }
                }
            }
        }
    }
}