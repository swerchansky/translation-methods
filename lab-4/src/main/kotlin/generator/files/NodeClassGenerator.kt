package generator.files

import dsl.generateClass
import generator.Constants.ATTR_SYMBOL
import generator.Generator
import generator.VisitorData
import java.io.File

class NodeClassGenerator : Generator {
    override fun generate(data: VisitorData, stringPath: String, prefix: String) {
        File(stringPath, "${prefix}Node.kt").writeText(
            generateClass("${prefix}Node", isDataClass = true) {
                packageName(data.packageName)
                argument(
                    argumentName = "id",
                    argumentType = "Int",
                    isVal = true
                )
                argument(
                    argumentName = "nodeName",
                    argumentType = "String",
                    isVal = true
                )
                argument(
                    argumentName = "children",
                    argumentType = "List<${prefix}Node>",
                    defaultValue = "emptyList()",
                    isVal = true
                )
                data.nodeValues.forEach {
                    argument(it.removePrefix(ATTR_SYMBOL).removeSuffix(ATTR_SYMBOL))
                }
            }
        )
    }
}