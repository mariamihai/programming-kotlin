package part1.chapter6

fun nickName(name: String?): String? {
    if (name == "William") {
        return "Bill"
    }

    if (name != null) {
        return name.reversed()
    }

    return null
}

println("Nickname for William is ${nickName("William")}")
println("Nickname for Venkat is ${nickName("Venkat")}")
println("Nickname for null is ${nickName(null)}")

// String? is the nullable type for non-nullable type in Kotlin - String