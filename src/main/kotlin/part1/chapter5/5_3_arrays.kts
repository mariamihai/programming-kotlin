package part1.chapter5

// Arrays are mutable

val friends = arrayOf("Tintin", "Snowy", "Haddock", "Calculus")
println("${friends[0]} and ${friends[1]}") // Tintin and Snowy

val numbers = arrayOf(1, 2, 3)
// equivalent to intArrayOf(1, 2, 3) but creates an array of boxed Integer types
// better to use intArrrayOf
println(numbers.size) // 3
println(numbers.average()) // 2.0

val numbers1 = intArrayOf(1, 2, 3)
println(numbers1::class) //class kotlin.IntArray
println(numbers1.javaClass) //class [I


println(Array(5) {i -> (i+1) * (i+1)}.sum()) // 55