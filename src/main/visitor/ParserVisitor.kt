package visitor

import token.NumberToken
import token.Token
import token.bracket.Bracket
import token.bracket.LeftBracket
import token.operation.Operation
import java.util.*

class ParserVisitor : TokenVisitor {
    private val tokens: MutableList<Token?> = ArrayList()
    private val stack: Deque<Token?> = ArrayDeque()

    override fun visit(token: NumberToken) {
        tokens.add(token)
    }

    override fun visit(token: Bracket) {
        if (token is LeftBracket) {
            stack.push(token)
            return
        }
        //dumping everything until meeting left bracket
        while (!stack.isEmpty() && stack.peek() !is LeftBracket) {
            tokens.add(stack.pop())
        }
        if (stack.isEmpty()) throw RuntimeException("wrong parenthesis")
        stack.pop()
    }

    override fun visit(token: Operation) {
        while ((!stack.isEmpty() && stack.peek() is Operation)
                && (stack.peek() as Operation).priority >= token.priority) {
            tokens.add(stack.pop())
        }
        stack.push(token)
    }

    val polishTokens: List<Token?>
        get() {
            while (!stack.isEmpty()) {
                val token = stack.pop() as? Operation ?: throw RuntimeException("wrong parenthesis")
                tokens.add(token)
            }
            return tokens.toMutableList()
        }
}