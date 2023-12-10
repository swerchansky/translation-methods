package exception

import analyzer.Token

class ParserException(expectedToken: List<Token>, actualToken: Token?, position: Int) : Throwable() {
    override val message: String = "Expected token $expectedToken at position $position, but found $actualToken"
}