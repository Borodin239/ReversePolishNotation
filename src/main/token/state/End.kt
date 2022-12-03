package token.state

import token.Tokenizer

class End(tokenizer: Tokenizer) : State(tokenizer) {
    override fun token() = throw RuntimeException("Trying to get token of end state")
    override fun nextState() = throw RuntimeException("Trying to get next state after end state")
}