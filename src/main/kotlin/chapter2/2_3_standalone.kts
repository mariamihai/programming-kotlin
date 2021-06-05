import java.lang.RuntimeException

// When the code is compiled or executed as script, Kotlin
// will create wrapper classes and methods as necessary to
// satisfy the JVM expectations

fun something() {
    println("something() was called")

    throw RuntimeException("oops")
}


println("Not in a function. Calling something().")
try {
    something()
} catch (ex: Exception) {
    val stackTrace = ex.stackTrace
    println(stackTrace[0])
    println(stackTrace[1])
}