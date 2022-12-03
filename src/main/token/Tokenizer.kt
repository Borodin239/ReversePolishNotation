package token

import token.state.End
import token.state.Start
import token.state.State

class Tokenizer(input: String) {
    private var state: State = Start(this)
    private val input: String
    private var index: Int
    var curChar: Char
    private val operations = listOf('+', '-', '*', '/')
    private val brackets = listOf('(', ')')

    init {
        if (input.isEmpty()) throw RuntimeException("empty input")
        this.input = input
        index = 0
        curChar = input[index]
    }

    fun getTokens(): List<Token> {
        val tokens = ArrayList<Token>()
        skipWhitespaces()
        nextState()
        while (!isEndingState()) {
            tokens.add(state.token())
            skipWhitespaces()
            nextState()
        }
        return tokens
    }

    private fun skipWhitespaces() {
        while (index < input.length && Character.isWhitespace(curChar)) {
            nextChar()
        }
    }

    private fun nextState() {
        state = state.nextState()
    }

    fun nextChar() {
        index++
        if (index < input.length) {
            curChar = input[index]
        }
    }

    private fun isEndingState() = state is End
    fun isOperation() = operations.contains(curChar)
    fun isBracket() = brackets.contains(curChar)
    fun isDigit() = Character.isDigit(curChar)
    fun isEnd() = index >= input.length
}