package visitor

import token.NumberToken
import token.Token
import token.bracket.Bracket
import token.operation.Operation
import java.util.*

class CalcVisitor : TokenVisitor {
    private val stack: Deque<Token> = ArrayDeque()
    override fun visit(token: NumberToken) = stack.push(token)

    override fun visit(token: Bracket) = throw RuntimeException("bracket in polish")

    override fun visit(token: Operation) {
        val rightToken = stack.pop()
        val leftToken = stack.pop()
        if (rightToken !is NumberToken || leftToken !is NumberToken) {
            throw RuntimeException("no arguments for operation found")
        }
        val left = leftToken.value
        val right = rightToken.value
        val result = token.calculate(left, right)
        stack.push(NumberToken(result))
    }

    val result: Int
        get() {
            if (stack.size != 1) {
                throw RuntimeException("stack must contain exactly 1 element")
            }
            val token = stack.pop() as? NumberToken ?: throw RuntimeException("stack must contain number")
            return token.value
        }
}