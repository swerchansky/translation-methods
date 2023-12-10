import analyzer.LexicalAnalyzer
import analyzer.Token.*
import exception.ParserException
import io.github.rchowell.dotlin.DotRootGraph
import io.github.rchowell.dotlin.digraph
import java.io.*


class Parser {
    private var id = 0
        get() = field++
    private lateinit var analyzer: LexicalAnalyzer

    fun parse(stream: InputStream): Tree {
        analyzer = LexicalAnalyzer(stream)
        return S()
    }

    private fun S(): Tree {
        return Tree(node = "S", id, V(), N(), DD(), D())
    }

    private fun V(): Tree {
        analyzer.nextToken()
        return when (analyzer.token) {
            VAR -> Tree(VAR.value, id)
            else -> throw ParserException(listOf(VAR), analyzer.token, analyzer.position)
        }
    }

    private fun N(): Tree {
        analyzer.nextToken()
        return when (analyzer.token) {
            NAME -> Tree(analyzer.tokenValue, id)
            else -> throw ParserException(listOf(NAME), analyzer.token, analyzer.position)
        }
    }

    private fun DD(): Tree {
        analyzer.nextToken()
        return when (analyzer.token) {
            DD -> Tree(DD.value, id)
            else -> throw ParserException(listOf(DD), analyzer.token, analyzer.position)
        }
    }

    private fun D(): Tree {
        analyzer.nextToken()
        return when (analyzer.token) {
            ARRAY -> Tree(ARRAY.value, id, LB(), E(), RB())
            TUPLE -> Tree(TUPLE.value, id, LB(), T(), RB())
            else -> throw ParserException(listOf(ARRAY, TUPLE), analyzer.token, analyzer.position)
        }
    }

    private fun E(): Tree {
        analyzer.nextToken()
        return when (analyzer.token) {
            TYPE -> Tree(analyzer.tokenValue, id)
            else -> throw ParserException(listOf(TYPE), analyzer.token, analyzer.position)
        }
    }

    private fun T(): Tree {
        analyzer.nextToken()
        return when (analyzer.token) {
            TYPE -> Tree(node = "T", id, Tree(analyzer.tokenValue, id), F())
            else -> throw ParserException(listOf(ARRAY, TYPE), analyzer.token, analyzer.position)
        }
    }

    private fun F(): Tree {
        analyzer.nextTokenSafe()
        return when (analyzer.token) {
            CM -> {
                analyzer.nextToken()
                Tree(node = "F", id, Tree(CM.value, id), E(), F())
            }
            else -> Tree(node = "F", id)
        }
    }

    private fun LB(): Tree {
        analyzer.nextToken()
        return when (analyzer.token) {
            LB -> Tree(LB.value, id)
            else -> throw ParserException(listOf(LB), analyzer.token, analyzer.position)
        }
    }

    private fun RB(): Tree {
        analyzer.nextToken()
        return when (analyzer.token) {
            RB -> Tree(RB.value, id)
            else -> throw ParserException(listOf(RB), analyzer.token, analyzer.position)
        }
    }

    private fun CM(): Tree {
        analyzer.nextToken()
        return when (analyzer.token) {
            CM -> Tree(CM.value, id)
            else -> throw ParserException(listOf(RB), analyzer.token, analyzer.position)
        }
    }
}
