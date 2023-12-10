package analyzer

import exception.LexicalException
import java.io.InputStream
import kotlin.properties.Delegates.notNull

class LexicalAnalyzer(private val stream: InputStream) {
    private var currentChar by notNull<Char>()
    private var isNeedSkip: Boolean = false
        get() = field.also { field = false }
    var position = 0
        private set
    var token: Token? = null
        private set
    var tokenValue: String = ""
        private set

    init {
        nextChar()
    }

    fun nextTokenSafe() {
        nextToken()
        isNeedSkip = true
    }

    fun nextToken() {
        if (isNeedSkip) return
        skipWhitespaces()
        token = when (currentChar) {
            '<' -> nextAndGet(Token.LB)
            '>' -> nextAndGet(Token.RB)
            ':' -> nextAndGet(Token.DD)
            ',' -> nextAndGet(Token.CM)
            '\uFFFF' -> Token.END
            else -> getMulticharToken()
        }
    }

    private fun getMulticharToken(): Token {
        var token = ""
        while (currentChar.isLetterOrDigit()) {
            token += currentChar
            nextChar()
        }
        return when {
            token in Token.TYPE.values -> tokenWithValue(Token.TYPE, token)
            token == Token.VAR.value -> Token.VAR
            token == Token.ARRAY.value -> Token.ARRAY
            token == Token.TUPLE.value -> Token.TUPLE
            token.matches(Regex("[a-zA-Z][a-zA-Z0-9]*")) -> tokenWithValue(Token.NAME, token)
            else -> throw LexicalException("Unexpected token: $token", position)
        }
    }

    private fun skipWhitespaces() {
        while (currentChar.isWhitespace()) {
            nextChar()
        }
    }

    private fun nextChar() {
        currentChar = stream.read().toChar()
        position++
    }

    private fun nextAndGet(token: Token): Token {
        nextChar()
        return token
    }

    private fun tokenWithValue(token: Token, value: String): Token {
        tokenValue = value
        return token
    }
}
