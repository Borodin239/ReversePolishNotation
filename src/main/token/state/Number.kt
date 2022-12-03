package token.state

import token.NumberToken
import token.Token
import token.Tokenizer

class Number(tokenizer: Tokenizer) : State(tokenizer) {

    override fun token(): Token {
        val builder = StringBuilder()
        while (!tokenizer.isEnd() && tokenizer.isDigit()) {
            builder.append(tokenizer.curChar)
            tokenizer.nextChar()
        }
        return NumberToken(builder.toString().toInt())
    }

    override fun nextState(): State {
        if (tokenizer.isEnd()) return End(tokenizer)
        if (tokenizer.isOperation() || tokenizer.isBracket()) return Start(tokenizer)
        return Error(tokenizer)
    }
}