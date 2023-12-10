import exception.LexicalException
import exception.ParserException
import io.github.rchowell.dotlin.DotRootGraph
import io.github.rchowell.dotlin.digraph
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.File
import kotlin.random.Random

class ParserTest {
    private val parser = Parser()
    private val outPath = File("src/test/out")

    @Test
    fun `simple test`() = test("var name: Array<Int>", "simple_test")

    @Test
    fun `string type test`() = test("var a: Array<String>", "string_type_test")

    @Test
    fun tuple() = test("var a: Tuple<Int>", "tuple")

    @Test
    fun `lexer error`() = testError<LexicalException>("13251")

    @Test
    fun `parser var error`() = testError<ParserException>("val a: Array<Int>")

    @Test
    fun `parser dd error`() = testError<ParserException>("var a Array<Int>")

    @Test
    fun `parser array error`() = testError<ParserException>("var a: Int")

    @Test
    fun `parser lb error`() = testError<ParserException>("var a: Array Int>")

    @Test
    fun `parser rb error`() = testError<ParserException>("var a: Array<Int")

    private fun test(input: String, name: String) {
        val tree = parser.parse(input.byteInputStream())
        val graph = makeGraph(tree)
        saveImage(graph, name)
    }

    private inline fun <reified T : Throwable> testError(input: String) {
        assertThrows<T> {
            parser.parse(input.byteInputStream())
        }
    }

    private fun makeGraph(tree: Tree): DotRootGraph {
        val graph = digraph {
            addSubgraph(tree)
        }
        println(graph.dot())
        return graph
    }

    private fun DotRootGraph.addSubgraph(tree: Tree) {
        tree.childrens.forEach {
            "\"${tree.id}\"" - "\"${it.id}\""
        }
        +subgraph {
            tree.childrens.forEach {
                +it.id.toString() + {
                    label = it.node
                }
            }
            tree.childrens.forEach {
                addSubgraph(it)
            }
        }
    }

    private fun saveImage(graph: DotRootGraph, name: String) {
        val tempFile = createTempFile(name, graph.dot())
        val process = ProcessBuilder(
            "dot",
            "-Tpng",
            "-o",
            outPath.resolve("$name.png").absolutePath,
            tempFile.absolutePath
        ).start()
        process.waitFor()
        cleanTempFile(name)
    }

    private fun createTempFile(name: String, content: String): File {
        val file = File(outPath, name)
        file.writeText(content)
        return file
    }

    private fun cleanTempFile(name: String) {
        val file = File(outPath, name)
        file.delete()
    }
}