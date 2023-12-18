package generator.files

import dsl.generateClass
import generator.Constants.EOF
import generator.Constants.EPS
import generator.Constants.START
import generator.Generator
import generator.VisitorData
import java.io.File

class ParserClassGenerator : Generator {
    override fun generate(data: VisitorData, stringPath: String) {
        File(stringPath, "Parser.kt").writeText(
            generateClass("Parser") {
                packageName(data.packageName)
                argument("lexer", "LexerAnalyzer", isVal = true, isPrivate = true)

                variable("text", "String", "\"\"", isVar = true, isPrivate = true)

                function("parse", "Node") {
                    +"return $START()"
                }

                data.rules.keys.forEach { ruleName ->
                    function(ruleName, "Node", isPrivate = true) {
                        +"val children = mutableListOf<Node>()"
                        +"val result = Node(\"$ruleName\", children)"
                        generateWhen("lexer.token") {
                            data.first[ruleName]?.forEach firstFor@ { first ->
                                var varIndex = 0
                                val ruleNumber = data.ruleNumberFromFirst[ruleName]?.get(first) ?: 0
                                if (first == EPS) {
                                    data.follow[ruleName]?.forEach { follow ->
                                        val nodeName = if (follow == EOF) EOF else EPS
                                        condition("Token.$follow") {
                                            +"children += Node(\"$nodeName\")"
                                            +"return result"
                                        }
                                    }
                                    return@firstFor
                                }
                                condition("Token.$first") {
                                    data.rules[ruleName]?.get(ruleNumber)?.forEach { rulePart ->
                                        if (rulePart in data.tokens.keys) {
                                            +"check(Token.$rulePart, \"$rulePart\")"
                                            +"text = lexer.tokenValue"
                                            if (rulePart == EOF) {
                                                +"children += Node(\"$EOF\")"
                                            } else {
                                                +"children += Node(text)"
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
                                    +"throw Exception()"
                                }
                        }
                    }
                }

                function("check", isPrivate = true) {
                    argument("token", "Token")
                    argument("rule", "String")
                    generateIf("lexer.token != token") {
                        +"throw Exception()"
                    }
                }
            }
        )
    }
}