import antlr.ExpressionBaseVisitor
import antlr.ExpressionParser
import java.lang.Exception
import kotlin.math.pow

class MyExpressionVisitor : ExpressionBaseVisitor<Int>() {
    var output = ""
        private set
    private val variables = HashMap<String, Int>()

    override fun visitStart(ctx: ExpressionParser.StartContext?): Int {
        val result = visit(ctx?.expression())
        val variable = ctx?.VARIABLE()?.text ?: ""
        variables[variable] = result
        output += "$variable = $result"
        output += System.lineSeparator()
        ctx?.start()?.let { visit(it) }
        return 0
    }

    override fun visitBinExpr(ctx: ExpressionParser.BinExprContext?): Int {
        val left = visit(ctx?.left)
        val right = visit(ctx?.right)
        val op = ctx?.op?.text
        return when (op) {
            "*" -> left * right
            "/" -> left / right
            "-" -> left - right
            "+" -> left + right
            "^" -> left.toDouble().pow(right.toDouble()).toInt()
            else -> throw Exception()
        }
    }

    override fun visitUnaryExpr(ctx: ExpressionParser.UnaryExprContext?): Int {
        var sign = 1
        ctx?.MINUS()?.forEach { _ -> sign *= -1 }
        ctx?.VARIABLE()?.text?.let {
            return (variables[it] ?: 0) * sign
        }
        ctx?.NUMBER()?.text?.let {
            return it.toInt() * sign
        }
        return 0
    }

    override fun visitBracketsExpr(ctx: ExpressionParser.BracketsExprContext?): Int {
        return visit(ctx?.expr)
    }
}