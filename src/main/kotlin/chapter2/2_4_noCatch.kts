package chapter2

// Kotlin doesn't force you to catch any exception
// (The program terminates of course if the exception is unhandled)

// Previous example (2_3_standalone.kts):
import java.lang.RuntimeException

// When the code is compiled or executed as script, Kotlin
// will create wrapper classes and methods as necessary to
// satisfy the JVM expectations

fun something() {
    println("something() was called")

    throw RuntimeException("oops")
}

println("Not in a function. Calling something(). This is valid")
//something()

println("\nNext example:")
println("Taking a nap and I am not going to try-catch.")
Thread.sleep(1000)
println("This felt good even if it took only one second.")