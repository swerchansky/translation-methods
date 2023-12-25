package autogenerated



class Parser(private val lexer: LexerAnalyzer, ) {
	private var text: String = ""
	private var id = 0
	  get() = field++
	 val stack = ArrayDeque<Int>() 

	fun parse(): Node {
		return start()
	}
	
	private fun expression(): Node {
		val children = mutableListOf<Node>()
		val result = Node(id, "expression", children)
		when (lexer.token) {
			Token.EOF -> {
				result.value = stack.last();
				children += Node(id, "EOF")
				return result
			}
	
			Token.PLUS -> {
				check(Token.PLUS, "PLUS")
				text = lexer.tokenValue
				children += Node(id, text)
				lexer.nextToken()
				val var0 = term()
				children += var0
				val second = stack.removeLast(); val first = stack.removeLast(); stack.addLast(first + second);
				val var1 = expression()
				children += var1
				result.value = var1.value;
				return result
			}
	
			Token.MINUS -> {
				check(Token.MINUS, "MINUS")
				text = lexer.tokenValue
				children += Node(id, text)
				lexer.nextToken()
				val var0 = term()
				children += var0
				val second = stack.removeLast(); val first = stack.removeLast(); stack.addLast(first - second);
				val var1 = expression()
				children += var1
				result.value = var1.value;
				return result
			}
	
			else -> {
				throw Exception()
			}
	
		}
	
	}
	
	private fun term2(): Node {
		val children = mutableListOf<Node>()
		val result = Node(id, "term2", children)
		when (lexer.token) {
			Token.DIV -> {
				check(Token.DIV, "DIV")
				text = lexer.tokenValue
				children += Node(id, text)
				lexer.nextToken()
				val var0 = primary()
				children += var0
				val second = stack.removeLast(); val first = stack.removeLast(); stack.addLast(first / second);
				val var1 = term2()
				children += var1
				result.value = var1.value;
				return result
			}
	
			Token.MULT -> {
				check(Token.MULT, "MULT")
				text = lexer.tokenValue
				children += Node(id, text)
				lexer.nextToken()
				val var0 = primary()
				children += var0
				val second = stack.removeLast(); val first = stack.removeLast(); stack.addLast(first * second);
				val var1 = term2()
				children += var1
				result.value = var1.value;
				return result
			}
	
			Token.EOF -> {
				result.value = stack.last();
				children += Node(id, "EOF")
				return result
			}
	
			Token.PLUS -> {
				result.value = stack.last();
				children += Node(id, "EPS")
				return result
			}
	
			Token.MINUS -> {
				result.value = stack.last();
				children += Node(id, "EPS")
				return result
			}
	
			else -> {
				throw Exception()
			}
	
		}
	
	}
	
	private fun start(): Node {
		val children = mutableListOf<Node>()
		val result = Node(id, "start", children)
		when (lexer.token) {
			Token.NUMBER -> {
				val var0 = term()
				children += var0
				result.value = var0.value
				val var1 = expression()
				children += var1
				result.value = var1.value
				check(Token.EOF, "EOF")
				text = lexer.tokenValue
				children += Node(id, "EOF")
				lexer.nextToken()
				return result
			}
	
			Token.LB -> {
				val var0 = term()
				children += var0
				result.value = var0.value
				val var1 = expression()
				children += var1
				result.value = var1.value
				check(Token.EOF, "EOF")
				text = lexer.tokenValue
				children += Node(id, "EOF")
				lexer.nextToken()
				return result
			}
	
			else -> {
				throw Exception()
			}
	
		}
	
	}
	
	private fun term(): Node {
		val children = mutableListOf<Node>()
		val result = Node(id, "term", children)
		when (lexer.token) {
			Token.NUMBER -> {
				val var0 = primary()
				children += var0
				val var1 = term2()
				children += var1
				result.value = var1.value;
				return result
			}
	
			Token.LB -> {
				val var0 = primary()
				children += var0
				val var1 = term2()
				children += var1
				result.value = var1.value;
				return result
			}
	
			else -> {
				throw Exception()
			}
	
		}
	
	}
	
	private fun primary(): Node {
		val children = mutableListOf<Node>()
		val result = Node(id, "primary", children)
		when (lexer.token) {
			Token.NUMBER -> {
				check(Token.NUMBER, "NUMBER")
				text = lexer.tokenValue
				children += Node(id, text)
				lexer.nextToken()
				result.value = text.toInt(); stack.addLast(text.toInt());
				return result
			}
	
			Token.LB -> {
				check(Token.LB, "LB")
				text = lexer.tokenValue
				children += Node(id, text)
				lexer.nextToken()
				val var0 = start()
				children += var0
				check(Token.RB, "RB")
				text = lexer.tokenValue
				children += Node(id, text)
				lexer.nextToken()
				return result
			}
	
			else -> {
				throw Exception()
			}
	
		}
	
	}
	
	private fun check(token: Token, rule: String): Unit {
		if (lexer.token != token) {
			throw Exception()
		}
	
	}
}