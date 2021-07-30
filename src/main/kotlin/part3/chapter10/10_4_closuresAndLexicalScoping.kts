package part3.chapter10

var factor = 2
val doubleIt = { e: Int -> e * factor}

// The Lambda is a closure, it closes over the defining scope to bind to
// the properties and methods that aren't local.

// Lexical scoping - defines how variable names are resolved in nested
// functions: inner functions contain the scope of parent functions
// even if the parent function has returned (closure).

//var factor = 2
val doubled = listOf(1, 2).map { it * factor }
val doubledAlso = sequenceOf(1, 2).map { it * factor }

factor = 0
doubled.forEach { println(it) } // 2 4
doubledAlso.forEach { println(it) } // 0 0

// Using mutable variables from within a closure is often a source
// of error and should be avoided. Keep closure as pure functions
// to avoid confusion and to minimize errors.