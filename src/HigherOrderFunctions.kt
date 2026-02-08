fun displayMessage(mes: () -> Unit) {
    mes()
}

fun morning() {
    println("Good morning!")
}

fun action(a: Int, b: Int, operation: (Int, Int) -> Int) {
    println(operation(a, b))
}

fun sum(a: Int, b: Int) = a + b
fun multiply(a: Int, b: Int) = a * b
fun subtract(a: Int, b: Int) = a - b

fun selectAction(key: Int): (Int, Int) -> Int {
    return when (key) {
        1 -> ::sum
        2 -> ::multiply
        else -> ::subtract
    }
}

fun main() {
    displayMessage(::morning)
    action(5, 3, ::sum)
    val action1 = selectAction(1)
    println(action1(10, 5))
}