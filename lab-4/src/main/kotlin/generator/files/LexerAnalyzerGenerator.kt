package generator.files

import dsl.generateClass
import generator.Generator
import generator.VisitorData
import java.io.File

class LexerAnalyzerGenerator : Generator {
    override fun generate(data: VisitorData, stringPath: String) {
        File("$stringPath/LexerAnalyzer.kt").writeText(
            generateClass("LexerAnalyzer") {
                packageName(data.packageName)
                import("java.io.InputStream")
                argument("stream", "InputStream", isVal = true, isPrivate = true)

                variable("position", "Int", "0", isVar = true)
                variable("currentChar", "Int", "-1", isVar = true)
                variable("token", "Token", "Token.EOF", isVar = true)
                variable("tokenValue", "String", "\"\"", isVar = true)
                variable("tokenText", "StringBuilder", "StringBuilder()", isVar = true)

                init {
                    +"nextChar()"
                    +"nextToken()"
                }

                function("nextToken") {
                    +"skipWhitespaces()"
                    +"var string = \"\""
                    +"var last: Char"

                    generateWhile("!currentChar.toChar().isWhitespace()") {
                        generateIf("currentChar < 0") {
                            +"string = tokenText.toString()"
                            +"tokenText.clear()"
                            +"token = Token.EOF"
                            +"tokenValue = \"EOF\""
                            +"break"
                        }

                        +"last = currentChar.toChar()"
                        +"string = tokenText.toString()"
                        +"tokenText.append(currentChar.toChar())"
                        val isToken = data.tokens.values.joinToString(separator = " || ") { s ->
                            getConditionForToken(s)
                        }
                        generateIf(isToken) {
                            +"nextChar()"
                            generateIf("currentChar < 0 || currentChar.toChar().isWhitespace()") {
                                +"string = tokenText.toString()"
                                +"tokenText.clear()"
                                +"break"
                            }

                            generateElse {
                                +"tokenText.clear()"
                                +"tokenText.append(last)"
                                +"nextChar()"
                                +"break"
                            }
                        }
                    }
                    data.tokens.keys.forEach { token ->
                        val tokenValue = data.tokens.getOrDefault(token, "")
                        generateIf(getConditionForToken(tokenValue)) {
                            +"token = Token.$token"
                            +"tokenValue = \"${data.tokens[token]}\""
                            +"return"
                        }
                    }
                }

                function("nextChar", isPrivate = true) {
                    +"currentChar = stream.read()"
                    +"position++"
                }

                function("skipWhitespaces", isPrivate = true) {
                    generateWhile("currentChar.toChar().isWhitespace()") {
                        +"nextChar()"
                    }
                }
            }
        )
    }

    private fun getConditionForToken(tokenValue: String): String {
        return if (tokenValue.startsWith("/") && tokenValue.endsWith("/") && tokenValue.length > 2) {
            val regex = tokenValue.removePrefix("/").removeSuffix("/")
            "string.matches(\"$regex\".toRegex())"
        } else {
            "string == \"$tokenValue\""
        }
    }
}