package chapter7

// Experimental in Kotlin at the time.
// You get the benefit of classes at compile time but you get the
// benefits of using a primitive at runtime - the class is transformed
// into a primitive in the bytecode.

// warning: the feature "inline classes" is experimental
inline class SSN(val id: String)

fun receiveSSN(ssn: SSN) {
    println("Received $ssn")
}

receiveSSN(SSN("abc"))

// If the code is compiled with the -XXLanguage:+InlineClasses
// command-line option, to indicate that we’re using an experimental
// feature, then the function receiveSSN() will be compiled to receive
// a String instead of an instance of SSN.

// When invoking, however, the Kotlin compiler will verify that the
// receiveSSN() function is invoked with an instance of SSN and not
// a raw string.

// inline classes may have properties and methods and may implement
// interfaces as well. Under the hood, methods will be rewritten as
// static methods that receive the primitive types that are being
// wrapped by the inline class. inline classes are required to be
// final and aren’t allowed to extend from other classes.

