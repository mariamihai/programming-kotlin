package part1.chapter6

fun nickName(name: String?): String {
    if (name == "William") {
        return "Bill"
    }

    return name?.reversed()?.toUpperCase() ?: "Joker"
}

println("Nickname for William is ${nickName("William")}")
println("Nickname for Venkat is ${nickName("Venkat")}")
println("Nickname for null is ${nickName(null)}")
