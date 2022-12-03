package token.bracket

import token.Token
import visitor.TokenVisitor

abstract class Bracket : Token {
    override fun accept(visitor: TokenVisitor) {
        visitor.visit(this)
    }
}