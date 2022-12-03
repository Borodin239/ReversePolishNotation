package token

import visitor.TokenVisitor

class NumberToken(
    val value: Int
) : Token {

    override fun toString(): String {
        return value.toString()
    }

    override fun accept(visitor: TokenVisitor) {
        visitor.visit(this)
    }
}