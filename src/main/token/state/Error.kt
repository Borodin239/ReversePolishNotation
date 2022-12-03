package token.state

import token.Tokenizer

class Error(
    tokenizer: Tokenizer
) : State(tokenizer) {
    override fun token() = throw RuntimeException("Trying to get token of error state")
    override fun nextState() = throw RuntimeException("Trying to get next state after error state")
}