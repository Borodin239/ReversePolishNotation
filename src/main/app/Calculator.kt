package app

import utils.Result

class Calculator {

    //TODO: вот тут основная логика
    fun apply(s: String): Result {
        return Result(s.length, s)
    }
}