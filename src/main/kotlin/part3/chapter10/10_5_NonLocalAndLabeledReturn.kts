package part3.chapter10

// return is not valid in lambdas by default but can be used in special
// situations - labeled return and non-local return

fun invokeWith(n: Int, action: (Int) -> Unit) {
    println("enter invokeWith $n")
    action(n)
    println("exit invokeWith $n")
}

fun caller() {
    (1..3).forEach { i ->
        invokeWith(i) {
            println("enter for $it")
            //if (it == 2) { return } // ERROR, return is not allowed here

            // Kotlin doesn’t know if we mean (1) to exit the immediate
            // Lambda and continue executing code within invokeWith()
            // right after the call to action(n), or (2) we mean to
            // exit the for loop we entered on line 2, or (3) exit
            // the function caller() we entered on line 1.
            println("exit for $it")
            }
        }
    println("end of caller")
}

caller()
println("after return from caller")
// enter invokeWith 1
// enter for 1
// exit for 1
// exit invokeWith 1
// ...
// end of caller
// after return from caller



// Labeled return => exit the current lambda immediately
fun callerWithLabeledReturn() {
    (1..3).forEach { i ->
        invokeWith(i) here@ {
            println("enter for $it")
            if (it == 2) {
                return@here
            }
            println("exit for $it")
        }
    }
    println("end of caller")
}

callerWithLabeledReturn()
// enter invokeWith 1
// enter for 1
// exit for 1
// exit invokeWith 1
// enter invokeWith 2
// enter for 2
// exit invokeWith 2
// enter invokeWith 3
// enter for 3
// exit for 3
// exit invokeWith 3
// end of caller

// The @here label can be removed and the return can be replaced with
// return@invokeHere.
// You can only return out of the current encompassing lambda.


println()
println()
println()
println()
println()
// Non-Local return => break out of the current function that's
// being implemented, right from within a lambda
fun callerNonLocalReturn() {
    (1..3).forEach { i ->
        println("in forEach for $i")
        if (i == 2) { return }

        invokeWith(i) {
            println("enter for $it")
            if (it == 2) { return@invokeWith }
                println("exit for $it")
            }
        }
    println("end of caller")
}

callerNonLocalReturn()
// in forEach for 1
// enter invokeWith 1
// enter for 1
// exit for 1
// exit invokeWith 1
// in forEach for 2


// forEach is defined as inline, that's why the return is permitted
// on line if (i == 2) { return }