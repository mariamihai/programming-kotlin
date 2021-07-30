package part1.chapter6

// Covariance - accept a generic of derived type where a generic base
// type is expected
// (Using the out specification)

open class Fruit
class Banana: Fruit()
class Orange: Fruit()

// Assume equal sizes
fun copyFromTo(from: Array<Fruit>, to: Array<Fruit>) {
    for (i in 0 until from.size) {
        to[i] = from[i]
    }
}

val fruitsBasket1 = Array<Fruit>(3) { _ -> Fruit() }
val fruitsBasket2 = Array(3) { Fruit() }
copyFromTo(fruitsBasket1, fruitsBasket2)

val bananaBasket = Array<Banana>(3) { _ -> Banana() }
val fruitsBasket = Array<Fruit>(3) { _ -> Fruit() }
//copyFromTo(bananaBasket, fruitsBasket) // ERROR: type mismatch


// Covariance on the parametric type - accept a type of itself or any
// of its derived types in its place
// We intend to only read OUT of the Array passed to the from
// parameter, there is no risk of passing any Array<T> where T is
// either of type Fruit or a derived class of Fruit

// Kotlin will assert that no method call is made on the from
// reference that would allow data to be passed IN

fun copyFromToOut(from: Array<out Fruit>, to: Array<Fruit>) {
    for (i in 0 until from.size) {
        to[i] = from[i]
        // Kotlin makes sure we are not adding IN the from array
        // an invalid type
//        from[i] = Fruit() // ERROR: type mismatch
//        from.set(i, to[i]) // ERROR: type mismatch
    }
}

copyFromToOut(bananaBasket, fruitsBasket) // OK

// Using covariance at the point of using a generic class -
// use-site variance or type projection

// Specifying covariance in the declaration of a generic type (rather
// than at the time of its use) - declaration-site variance

// Eg., the declaration of the List interface - List<out T>
// This allows passing List<Banana> to receiveFruits()
