package part1.chapter6

fun uppercase(name: String?): String? {
    return name?.reversed()?.toUpperCase()
}

println("Uppercase name for William is ${uppercase("William")}")
println("Uppercase name for Venkat is ${uppercase("Venkat")}")
println("Uppercase name for null is ${uppercase(null)}")
