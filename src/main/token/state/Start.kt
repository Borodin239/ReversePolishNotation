package token.state

import token.Token
import token.Tokenizer
import token.bracket.LeftBracket
import token.bracket.RightBracket
import token.operation.Divide
import token.operation.Minus
import token.operation.Multiply
import token.operation.Plus

class Start(tokenizer: Tokenizer) : State(tokenizer) {
    override fun token(): Token {
        val c = tokenizer.curChar
        tokenizer.nextChar()
        return when (c) {
            '*' -> Multiply()
            '/' -> Divide()
            '-' -> Minus()
            '+' -> Plus()
            '(' -> LeftBracket()
            ')' -> RightBracket()
            else -> throw RuntimeException("Unexpected token: $c")
        }
    }

    override fun nextState(): State {
        if (tokenizer.isEnd()) return End(tokenizer)
        if (tokenizer.isBracket() || tokenizer.isOperation()) return this
        return if (tokenizer.isDigit()) Number(tokenizer) else Error(tokenizer)
    }
}