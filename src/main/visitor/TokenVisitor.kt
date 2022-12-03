package visitor

import token.NumberToken
import token.bracket.Bracket
import token.operation.Operation

interface TokenVisitor {
    fun visit(token: NumberToken)
    fun visit(token: Bracket)
    fun visit(token: Operation)
}