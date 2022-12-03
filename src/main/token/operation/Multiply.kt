package token.operation

class Multiply : Operation() {
    override val priority = 1
    override fun toString() = "*"
    override fun calculate(left: Int, right: Int) = left * right
}