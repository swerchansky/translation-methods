package generator.files

import dsl.generateEnumClass
import generator.Generator
import generator.VisitorData
import java.io.File

class TokenGenerator : Generator {
    override fun generate(data: VisitorData, stringPath: String) {
        File("$stringPath/Token.kt").writeText(
            generateEnumClass("Token") {
                packageName(data.packageName)
                data.tokens.keys.forEach {
                    value(it)
                }
                value("EOF")
            }
        )
    }
}