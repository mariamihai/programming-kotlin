package chapter2

// Compiling with kotlinc-jvm, you get the next warning from kotlinc:
// warning: parameter 'n' is never used

// From Kotlin 1.3, main() params can be left out

fun compute(n: Int) = 0

fun main(args: Array<String>) = println(compute(4))