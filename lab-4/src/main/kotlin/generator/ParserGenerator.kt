package generator

import generator.files.LexerAnalyzerGenerator
import generator.files.NodeGenerator
import generator.files.TokenGenerator
import java.io.File

class ParserGenerator : Generator {
    private val generators = listOf(
        TokenGenerator(),
        NodeGenerator(),
        LexerAnalyzerGenerator(),
    )

    override fun generate(data: VisitorData, stringPath: String) {
        File(stringPath).also { it.mkdirs() }
        generators.forEach { it.generate(data, stringPath) }
    }
}