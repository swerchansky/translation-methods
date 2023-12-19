package generator.files

import dsl.generateEnumClass
import generator.Generator
import generator.VisitorData
import java.io.File

class TokenClassGenerator : Generator {
    override fun generate(data: VisitorData, stringPath: String, prefix: String) {
        File(stringPath, "${prefix}Token.kt").writeText(
            generateEnumClass("${prefix}Token") {
                packageName(data.packageName)
                data.tokens.keys.forEach {
                    value(it)
                }
            }
        )
    }
}