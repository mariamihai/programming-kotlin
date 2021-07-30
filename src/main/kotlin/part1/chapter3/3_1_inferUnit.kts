package part1.chapter3

// Kotlin will infer the type as Unit if the function
// isn’t returning anything
fun sayHello() = println("Well, hello")

// ERROR
// val message: String = sayHello()
// type mismatch: inferred type is Unit but String was expected