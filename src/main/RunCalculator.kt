import token.Token
import token.Tokenizer
import visitor.CalcVisitor
import visitor.ParserVisitor
import visitor.PrintVisitor

fun main() {
    val input = readLine()!!
    val tokenizer = Tokenizer(input)
    val tokens: List<Token> = tokenizer.getTokens()

    val parserVisitor = ParserVisitor()
    tokens.forEach{ token: Token -> token.accept(parserVisitor) }

    val polishTokens: List<Token?> = parserVisitor.polishTokens
    val printVisitor = PrintVisitor(System.out)
    polishTokens.forEach { token: Token? -> token?.accept(printVisitor) }
    println()

    val calcVisitor = CalcVisitor()
    polishTokens.forEach { token: Token? -> token?.accept(calcVisitor) }
    println(calcVisitor.result)
}