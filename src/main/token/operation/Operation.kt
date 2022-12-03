package token.operation

import token.Token
import visitor.TokenVisitor

abstract class Operation : Token {
    abstract val priority: Int
    abstract fun calculate(left: Int, right: Int): Int
    override fun accept(visitor: TokenVisitor) = visitor.visit(this)
}