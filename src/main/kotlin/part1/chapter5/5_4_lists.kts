package part1.chapter5

// Lists can be mutable or immutable
// Immutability is implied - listOf()
// Mutability is declared - mutableListOf()

val fruits: List<String> = listOf("Apple", "Banana", "Grape")
println(fruits) // [Apple, Banana, Grape]
println(fruits::class)
println(fruits.javaClass)

// Get a value
println("${fruits[0]} = ${fruits.get(0)}") // Apple = Apple

// Check if value in list
println(fruits.contains("Apple")) // true
println("Apple" in fruits) // true

// Can't add new values - compile error "Unresolved reference: add"
//fruits.add("Orange")

// Create a new list with previous values + the new element
val fruits2 = fruits + "Orange"
println(fruits) // [Apple, Banana, Grape]
println(fruits2) // [Apple, Banana, Grape, Orange]

// New list without an element
// if the element is not presents, the new list contains all the
// original elements
val fruits3 = fruits - "Banana"
println(fruits3) // [Apple, Grape]



// Mutable lists
println()
val fruitsM: MutableList<String> = mutableListOf("Apple", "Banana", "Grape")
println("${fruits::class}  ${fruits.javaClass}")
// class java.util.Arrays$ArrayList  class java.util.Arrays$ArrayList
println("${fruitsM::class}  ${fruitsM.javaClass}")
// class java.util.ArrayList  class java.util.ArrayList

fruitsM.add("Orange")