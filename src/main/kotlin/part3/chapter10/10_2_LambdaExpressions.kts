package part3.chapter10

// Passing Lambdas

fun isPrime(n: Int) = n > 1 && (2 until n).none {i -> n % i == 0}

// Uses it as the variable name, while the parameter declaration is omitted
fun isPrimeImplicitParameter(n: Int) = n > 1 && (2 until n).none {n % it == 0}


// Receiving Lambdas

fun walk1To(action: (Int) -> Unit, n: Int) =
    (1..n).forEach {action(it) }

walk1To({ i -> print(i) }, 5) // 12345


fun walk1ToTrailingLambda(n: Int, action: (Int) -> Unit) =
    (1..n).forEach { action(it) }

walk1ToTrailingLambda(5, {i -> print(i)})
walk1ToTrailingLambda(5) {i -> print(i)}
walk1ToTrailingLambda(5) { print(it) }


// Function references

//fun walk1To(action: (Int) -> Unit, n: Int) = (1..n).forEach(action)

// If a function is qualified to stand in for a Lambda, then it should
// be prefixed with ::
walk1ToTrailingLambda(5, ::print)
walk1ToTrailingLambda(5, System.out::println)

fun send(n: Int) = println(n)
walk1ToTrailingLambda(5, this::send)

object Terminal {
    fun write(value: Int) = println(value)
}
walk1ToTrailingLambda(5, Terminal::write)


// Function returning Functions

val names = listOf("Pam", "Pat", "Paul", "Paula")
println(names.find {name -> name.length == 5 }) // Paula
println(names.find { name -> name.length == 4 }) // Paul

fun predicateOfLength(length: Int): (String) -> Boolean {
    return {
        input: String -> input.length == length
    }
}
//fun predicateOfLength(length: Int) =
//    { input: String -> input.length == length }

println(names.find(predicateOfLength(5))) // Paula
println(names.find(predicateOfLength(4))) // Paul
