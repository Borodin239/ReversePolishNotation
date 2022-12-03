package token.operation

class Minus : Operation() {
    override val priority = 0
    override fun toString() = "-"
    override fun calculate(left: Int, right: Int) = left - right
}