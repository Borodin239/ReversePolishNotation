package token.operation

class Plus : Operation() {
    override val priority = 0
    override fun toString() = "+"
    override fun calculate(left: Int, right: Int) = left + right
}