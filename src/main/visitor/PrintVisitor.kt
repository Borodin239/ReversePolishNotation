package visitor

import token.NumberToken
import token.bracket.Bracket
import token.operation.Operation
import java.io.PrintStream

class PrintVisitor(private val out: PrintStream) : TokenVisitor {
    override fun visit(token: NumberToken) = out.print("$token ")
    override fun visit(token: Bracket) = out.print("$token ")
    override fun visit(token: Operation) = out.print("$token ")
}