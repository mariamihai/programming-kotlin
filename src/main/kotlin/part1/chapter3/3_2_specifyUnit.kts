package part1.chapter3

fun sayHello(): Unit = println("Well, hello")

val message: Unit = sayHello()

println("The result of sayHello is $message")
// The result of sayHello is kotlin.Unit
// (basically calling toString() on the Unit)