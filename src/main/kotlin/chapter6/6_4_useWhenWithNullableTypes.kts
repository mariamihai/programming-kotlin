package chapter6


// Use the safe-call or Elvis operator to extract values,
// and use 'when' to make decisions on nullable references.

fun nickName(name: String?) = when (name) {
    "William" -> "Bill"
    null -> "Joker"
    else -> name.reversed().toUpperCase()
}

println("Nickname for William is ${nickName("William")}")
println("Nickname for Venkat is ${nickName("Venkat")}")
println("Nickname for null is ${nickName(null)}")