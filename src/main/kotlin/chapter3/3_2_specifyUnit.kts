fun sayHello(): Unit = println("Well, hello")

val message: Unit = sayHello()

println("The result of sayHello is $message")
// The result of sayHello is kotlin.Unit
// (basically callin toString() on the Unit)