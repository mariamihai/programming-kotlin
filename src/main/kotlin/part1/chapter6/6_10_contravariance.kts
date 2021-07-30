package part1.chapter6

// Contravariance - a parametric type of base is accepted where an
// instance of a parametric type is expected
// (Using the in specification)

open class Fruit
class Banana: Fruit()
class Orange: Fruit()

// Assume equal sizes
fun copyFromTo(from: Array<out Fruit>, to: Array<Fruit>) {
    for (i in 0 until from.size) {
        to[i] = from[i]
    }
}

val things = Array<Any>(3) { _ -> Fruit() }
val bananaBasket = Array<Banana>(3) { _ -> Banana() }
//copyFromTo(bananaBasket, things) // ERROR: type mismatch


fun copyFromToIn(from: Array<out Fruit>, to: Array<in Fruit>) {
    for (i in 0 until from.size) {
        to[i] = from[i]
    }
}

copyFromToIn(bananaBasket, things) // OK

// Kotlin will allow method calls that set IN values on the parameter
// and will not allow methods that read OUT