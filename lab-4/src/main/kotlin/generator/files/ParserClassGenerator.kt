package generator.files

import dsl.generateClass
import generator.Constants.ATTR_SYMBOL
import generator.Constants.EOF
import generator.Constants.EPS
import generator.Constants.START
import generator.Generator
import generator.VisitorData
import java.io.File

class ParserClassGenerator : Generator {
    override fun generate(data: VisitorData, stringPath: String, prefix: String) {
        File(stringPath, "${prefix}Parser.kt").writeText(
            generateClass("${prefix}Parser") {
                packageName(data.packageName)
                +"private var id = 0"
                +"  get() = field++"
                data.attributes.forEach { +it.removePrefix(ATTR_SYMBOL).removeSuffix(ATTR_SYMBOL) }
                argument("lexer", "${prefix}LexerAnalyzer", isVal = true, isPrivate = true)

                variable("text", "String", "\"\"", isVar = true, isPrivate = true)

                function("parse", "${prefix}Node") {
                    +"return $START()"
                }

                data.rules.keys.forEach { ruleName ->
                    function(ruleName, "${prefix}Node", isPrivate = true) {
                        +"val children = mutableListOf<${prefix}Node>()"
                        +"val result = ${prefix}Node(id, \"$ruleName\", children)"
                        generateWhen("lexer.token") {
                            data.first[ruleName]?.forEach firstFor@ { first ->
                                var varIndex = 0
                                val ruleNumber = data.ruleNumberFromFirst[ruleName]?.get(first) ?: 0
                                if (first == EPS) {
                                    data.follow[ruleName]?.forEach { follow ->
                                        val nodeName = if (follow == EOF) EOF else EPS
                                        condition("${prefix}Token.$follow") {
                                            for (rulePart in data.rules[ruleName]!![ruleNumber]) {
                                                if (rulePart.startsWith(ATTR_SYMBOL)) {
                                                    +rulePart.removePrefix(ATTR_SYMBOL).removeSuffix(ATTR_SYMBOL)
                                                }
                                            }
                                            +"children += ${prefix}Node(id, \"$nodeName\")"
                                            +"return result"
                                        }
                                    }
                                    return@firstFor
                                }
                                condition("${prefix}Token.$first") {
                                    data.rules[ruleName]?.get(ruleNumber)?.forEach conditions@ { rulePart ->
                                        if (rulePart.startsWith(ATTR_SYMBOL)) {
                                            +rulePart.removePrefix(ATTR_SYMBOL).removeSuffix(ATTR_SYMBOL)
                                            return@conditions
                                        }
                                        if (rulePart in data.tokens.keys) {
                                            +"check(${prefix}Token.$rulePart, \"$rulePart\")"
                                            +"text = lexer.tokenValue"
                                            if (rulePart == EOF) {
                                                +"children += ${prefix}Node(id, \"$EOF\")"
                                            } else {
                                                +"children += ${prefix}Node(id, text)"
                                            }
                                            +"lexer.nextToken()"
                                        } else {
                                            +"val var$varIndex = $rulePart()"
                                            +"children += var$varIndex"
                                            varIndex++
                                        }
                                    }
                                    +"return result"
                                }
                            }
                                condition("else") {
                                    +"throw IllegalStateException(\"Unexpected token: \${lexer.token}\")"
                                }
                        }
                    }
                }

                function("check", isPrivate = true) {
                    argument("token", "${prefix}Token")
                    argument("rule", "String")
                    generateIf("lexer.token != token") {
                        +"throw IllegalStateException(\"Expected \$rule, but found \${lexer.token}\")"
                    }
                }
            }
        )
    }
}