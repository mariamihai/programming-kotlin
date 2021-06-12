fun greet(name : String, message: String = "Hello"): String {
    return "$message, $name"
}

val message: String = greet("Maria") // or greet(name = "Maria") // Hello, Maria
println(message)

println(greet(message = "Hey", name =  "Maria")) // Hey, Maria
println(greet("Maria", "Hi")) // Hi, Maria