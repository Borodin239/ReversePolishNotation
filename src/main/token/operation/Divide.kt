package token.operation

class Divide : Operation() {
    override val priority = 1
    override fun toString() = "/"
    override fun calculate(left: Int, right: Int): Int {
        if (right == 0) throw ArithmeticException("division by zero")
        return left / right
    }
}