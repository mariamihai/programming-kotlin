package chapter7

// If there is no primary constructor, then Kotlin creates a no-
// argument default constructor.
// If the primary constructor has default arguments for all parameters,
// then Kotlin creates a no-argument constructor in addition to the
// primary one.


// The secondary constructors are required to either call the primary
// constructor or call one of the other secondary constructors (as long
// as the primary constructor is called in the end).
// Secondary constructor's parameters can't be decorated with val or var
// (they don't define any properties).


class Person(val first: String, val last: String) {
    // The primary constructor defines 2 properties
    var fulltime = true
    var location: String = "-"

    // Secondary constructor
    constructor(first: String, last: String, fte: Boolean): this(first, last) {
        fulltime = fte
    }

    // Secondary constructor
    constructor(
        first: String, last: String, loc: String): this(first, last, false) {
        location = loc
    }
    override fun toString() = "$first $last $fulltime $location"
}

println(Person("Jane", "Doe")) // Jane Doe true -
println(Person("John", "Doe", false)) // John Doe false -
println(Person("Baby", "Doe", "home")) // Baby Doe false home