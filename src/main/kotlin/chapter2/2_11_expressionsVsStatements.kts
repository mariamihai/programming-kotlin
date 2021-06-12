package chapter2

// Java like code - if used as a statement; nothing is returned
fun canVoteJ(name: String, age: Int): String {
    val status: String
    if (age > 17) {
        status = "yes, please vote"
    } else {
        status = "nope, please come back"
    }
    return "$name, $status"
}
println(canVoteJ("Eve", 12))


// Equivalent in Kotlin - if as an expression
fun canVoteK(name: String, age: Int): String {
    val status = if (age > 17) "yes, please vote" else "nope, please come back"
    return "$name, $status"
}
println(canVoteK("Eve", 12))

// Try-catch is an expression as well in Kotlin
fun tryExpr(blowup: Boolean): Int {
    return try {
        if (blowup) {
            throw RuntimeException("fail")
        }
        2
    } catch(ex: Exception) {
        4
    } finally {
        //...
    }
}
println(tryExpr(false)) //2
println(tryExpr(true)) //4

// Assignment are not expressions.
// In Java: a = b = c
// In Kotlin this fails