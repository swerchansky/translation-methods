package lab2

import antlrgenerated.ParserGeneratorLexer
import antlrgenerated.ParserGeneratorParser
import generator.ParserGenerator
import generator.ParserGeneratorVisitorImpl
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File

fun main() {
    val inputGrammarPath = "src/test/kotlin/lab2/grammarLab2"
    val outputPath = "src/test/kotlin/lab2/autogenerated"
    val inputGrammar = File(inputGrammarPath)
    val stream = CharStreams.fromStream(inputGrammar.inputStream())
    val parser = ParserGeneratorParser(CommonTokenStream(ParserGeneratorLexer(stream)))
    val tree = parser.start()
    val visitor = ParserGeneratorVisitorImpl()
    visitor.visitStart(tree)

    ParserGenerator().generate(visitor.data, outputPath, "lab2")
}