package exception

class LexicalException(s: String, position: Int) : Throwable() {
    override val message: String = "Lexical error: $s at position $position"
}