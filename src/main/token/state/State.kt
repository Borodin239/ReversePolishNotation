package token.state

import token.Token
import token.Tokenizer

abstract class State (
    protected val tokenizer: Tokenizer
) {
    abstract fun token(): Token
    abstract fun nextState(): State
}