import antlr.ExpressionLexer
import antlr.ExpressionParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

import org.junit.jupiter.api.Test
import java.io.File

class MyExpressionVisitorTest {
    private val inPath = File("src/test/in")
    private val outPath = File("src/test/out")

    @Test
    fun `simple test`() = test("simple")

    @Test
    fun `two variables`() = test("two_variables")

    @Test
    fun `variables remember`() = test("variables_remember")

    @Test
    fun `example test`() = test("example")

    @Test
    fun `brackets test`() = test("brackets")

    @Test
    fun `unary minus`() = test("unary_minus")

    @Test
    fun `pow1 test`() = test("pow1")

    @Test
    fun `pow2 test`() = test("pow2")

    @Test
    fun `pow3 test`() = test("pow3")


    private fun test(name: String) {
        val input = File(inPath, "$name.in").readText()
        val stream = CharStreams.fromStream(input.byteInputStream())
        val parser = ExpressionParser(CommonTokenStream(ExpressionLexer(stream)))
        val tree = parser.start()
        val visitor = MyExpressionVisitor()
        visitor.visit(tree)
        writeOut(visitor.output, name)
    }

    private fun writeOut(output: String, name: String) {
        val file = File(outPath, "$name.out")
        file.writeText(output)
    }
}