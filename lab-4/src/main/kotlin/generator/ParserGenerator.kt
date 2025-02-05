package generator

import generator.files.LexerAnalyzerClassGenerator
import generator.files.NodeClassGenerator
import generator.files.ParserClassGenerator
import generator.files.TokenClassGenerator
import java.io.File

class ParserGenerator : Generator {
    private val generators = listOf(
        TokenClassGenerator(),
        NodeClassGenerator(),
        LexerAnalyzerClassGenerator(),
        ParserClassGenerator(),
    )

    override fun generate(data: VisitorData, stringPath: String, prefix: String) {
        val prefixFormatted = prefix.first().uppercase() + prefix.drop(1)
        File(stringPath).also { it.mkdirs() }
        generators.forEach { it.generate(data, stringPath, prefixFormatted) }
    }
}