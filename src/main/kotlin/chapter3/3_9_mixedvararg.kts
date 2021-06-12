package chapter3

fun greetMany(message: String, vararg names: String) {
    println("$message ${names.joinToString(", ")}")
}
greetMany("Hello", "Tom", "Jerry", "Spike") // Hello Tom, Jerry, Spike

fun greetMany2(vararg names: String, message: String) {
    println("$message ${names.joinToString(", ")}")
}
greetMany2("Tom", "Jerry", "Spike", message = "Hello") // Hello Tom, Jerry, Spike

// Vararg params
// - in the trailing position (otherwise named arguments are needed
// - before the last position when using a lambda expression as the last argument