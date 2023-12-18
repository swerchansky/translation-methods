package generator.files

import dsl.generateClass
import generator.Generator
import generator.VisitorData
import java.io.File

class NodeClassGenerator : Generator {
    override fun generate(data: VisitorData, stringPath: String) {
        File(stringPath, "Node.kt").writeText(
            generateClass("Node", isDataClass = true) {
                packageName(data.packageName)
                argument(
                    argumentName = "nodeName",
                    argumentType = "String",
                    isVal = true
                )
                argument(
                    argumentName = "children",
                    argumentType = "List<Node>",
                    defaultValue = "emptyList()",
                    isVal = true
                )
                data.nodeValues.forEach {
                    argument(it)
                }
            }
        )
    }
}