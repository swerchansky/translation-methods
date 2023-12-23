package generated.pascalVariables
import java.io.IOException
import java.io.Reader
import java.text.ParseException

class Lexer(private val stream: Reader) {

    constructor(s: String) : this(s.reader())

    var curPos = -1
    var curChar: Int = -1
    var token: Token = Token.EOF
    var tokenValue = ""
    val tokenText = StringBuilder()

    init {
        nextChar()
        nextToken()
    }

    private fun isBlank(c: Char): Boolean {
        return c == ' ' || c == '\r' || c == '\t' || c == '\n'
    }

    private fun nextChar() {
        try {
            curChar = stream.read()
        } catch (e: IOException) {
            throw ParseException(e.message, curPos + 1)
        } finally {
            ++curPos
        }
    }

    fun nextToken() {
        while (isBlank(curChar.toChar())) {
            nextChar()
        }

        var toString = ""
        var last: Char

        while (!isBlank(curChar.toChar())) {
            if (curChar == -1) {
                toString = tokenText.toString();
                tokenText.clear()
                token = Token.EOF
                tokenValue = "EOF"
                break;
            }
            last = curChar.toChar()
            toString = tokenText.toString()
            tokenText.append(curChar.toChar())
            val isToken = tokenText.matches("var".toRegex()) || tokenText.matches(":".toRegex()) || tokenText.matches(";".toRegex()) || tokenText.matches(",".toRegex()) || tokenText.matches("EPS".toRegex()) || tokenText.matches("\\$".toRegex()) || tokenText.matches("byte".toRegex()) || tokenText.matches("boolean".toRegex()) || tokenText.matches("word".toRegex()) || tokenText.matches("integer".toRegex()) || tokenText.matches("longint".toRegex()) || tokenText.matches("real".toRegex()) || tokenText.matches("double".toRegex()) || tokenText.matches("char".toRegex()) || tokenText.matches("string".toRegex()) || tokenText.matches("[_a-zA-Z][\\w]*".toRegex())
            if (isToken) {
                nextChar()
                if (isBlank(curChar.toChar()) || curChar == -1) {
                    toString = tokenText.toString()
                    tokenText.clear()
                    break
                }
            } else {
                tokenText.clear()
                tokenText.append(last)
                nextChar()
                break
            }
        }
        
        if (toString.matches("var".toRegex())) {
            token = Token.VAR
            tokenValue = toString
            return
        }
            
        if (toString.matches(":".toRegex())) {
            token = Token.COLON
            tokenValue = toString
            return
        }
            
        if (toString.matches(";".toRegex())) {
            token = Token.SEMICOLON
            tokenValue = toString
            return
        }
            
        if (toString.matches(",".toRegex())) {
            token = Token.COMMA
            tokenValue = toString
            return
        }
            
        if (toString.matches("\\$".toRegex())) {
            token = Token.EOF
            tokenValue = toString
            return
        }
            
        if (toString.matches("byte".toRegex())) {
            token = Token.BYTE
            tokenValue = toString
            return
        }
            
        if (toString.matches("boolean".toRegex())) {
            token = Token.BOOLEAN
            tokenValue = toString
            return
        }
            
        if (toString.matches("word".toRegex())) {
            token = Token.WORD
            tokenValue = toString
            return
        }
            
        if (toString.matches("integer".toRegex())) {
            token = Token.INTEGER
            tokenValue = toString
            return
        }
            
        if (toString.matches("longint".toRegex())) {
            token = Token.LONGINT
            tokenValue = toString
            return
        }
            
        if (toString.matches("real".toRegex())) {
            token = Token.REAL
            tokenValue = toString
            return
        }
            
        if (toString.matches("double".toRegex())) {
            token = Token.DOUBLE
            tokenValue = toString
            return
        }
            
        if (toString.matches("char".toRegex())) {
            token = Token.CHAR
            tokenValue = toString
            return
        }
            
        if (toString.matches("string".toRegex())) {
            token = Token.STRING
            tokenValue = toString
            return
        }
            
        if (toString.matches("[_a-zA-Z][\\w]*".toRegex())) {
            token = Token.NAME
            tokenValue = toString
            return
        }
            
    }
}
    