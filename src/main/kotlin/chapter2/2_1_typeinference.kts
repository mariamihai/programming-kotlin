// The type of variable is verified and type sanity is guaranteed
// at compile time in Kotlin. Variable type specification is optional.

val greet = "hello"

println(greet)
// The Kotlin class of the greet object
println(greet::class)
// Get the underlying Java class
println(greet.javaClass)