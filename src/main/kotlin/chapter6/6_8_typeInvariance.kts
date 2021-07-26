package chapter6

// Type Invariance - can't vary the type

open class Fruit
class Banana: Fruit()
class Orange: Fruit()

fun receiveFruits(fruits: Array<Fruit>) {
    println("Number of fruits: ${fruits.size}")
}

// Error - type mismatch
//val bananas: Array<Banana> = arrayOf()
//receiveFruits(bananas)



fun receiveFruitsList(fruits: List<Fruit>) {
    println("Number of fruits: ${fruits.size}")
}

// Array<T> is mutable but List<T> is immutable
val bananas: List<Banana> = listOf()
receiveFruitsList(bananas)

