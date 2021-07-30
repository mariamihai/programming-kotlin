package part1.chapter5

// Can be mutable or immutable

val fruits: Set<String> = setOf("Apple", "Banana", "Apple")
println(fruits) // [Apple, Banana]
println(fruits::class) // class java.util.LinkedHashSet
println(fruits.javaClass) // class java.util.LinkedHashSet

// Can create specific types with hashSetOf(), linkedSetOf(),
// sortedSetOf()