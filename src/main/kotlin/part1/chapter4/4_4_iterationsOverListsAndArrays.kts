package part1.chapter4

val array = arrayOf(1, 2, 3)
for (a in array) { print("$a, ") } // 1, 2, 3,

println()
val list = listOf(1, 2, 3)
for (l in list) { print("$l, ") } // 1, 2, 3,

// Getting the index
println()
val names = listOf("Tom", "Jerry", "Spike")
for (index in names.indices) {
    println("Position of ${names.get(index)} is $index")
}

// Getting the index and the value with destructuring
println()
for ((index, name) in names.withIndex()) {
    println("Position of $name is $index")
}