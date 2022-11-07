import app.Calculator

fun main() {
    val calc = Calculator()
    while (true) {
        println("Введите арифметическое выражение:")

        val s = readLine()!!
        try {
            val res = calc.apply(s)
            println("Выражение [$s] преобразовали в [${res.output}]. Результат вычислений: ${res.value}")
        } catch (e: RuntimeException) {
            error("Error")
        }

        println("Разобрать ещё одно выражение? (Y/no)")
        if (readLine() == "no") break
    }
}