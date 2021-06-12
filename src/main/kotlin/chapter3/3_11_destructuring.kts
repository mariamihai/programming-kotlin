package chapter3

// the destructuring in Kotlin is based on the position of properties instead of the names of the properties
fun getFullName() = Triple("John", "Quincy", "Adams")

// Valid:
//val result = getFullName()
//val first = result.first
//val middle = result.second
//val last = result.third
//println("$first $middle $last") // John Quincy Adams


// Better:
//val (first, middle, last) = getFullName()
//println("$first $middle $last") // John Quincy Adams


// If one or more of the properties is / are not needed
//val (first, _, last) = getFullName()
//println("$first $last") // John Adams

//val (_, _, last) = getFullName()
//println(last) // Adams

// Ignore some of the last properties
val (_, middle) = getFullName()
println(middle) // Quincy