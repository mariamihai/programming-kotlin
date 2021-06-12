fun max(vararg numbers: Int): Int {
    var large = Int.MIN_VALUE

    for (number in numbers) {
        large = if (number > large) number else large
    }

    return large
}

val values = intArrayOf(1, 5, 2)

//println(max(values)) // Type mismatch. Required: Int Found: IntArray
println(max(*values)) // 5

// When using lists:
println(max(*listOf(1, 5, 2).toIntArray())) // 5
