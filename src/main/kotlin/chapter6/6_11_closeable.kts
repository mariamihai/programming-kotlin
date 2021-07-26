package chapter6

//fun <T> useAndCloseSimple(input: T) {
//    input.close() //ERROR: unresolved reference: close
//}

// Restrict the parametric type to acceptable types
fun <T: AutoCloseable> useAndCloseType(input: T) {
    input.close() // OK
}

var writer = java.io.StringWriter()
writer.append("hello ")
useAndCloseType(writer)
println(writer) // hello



// If there are multiple constraints:
fun <T> useAndCloseMultipleTypes(input: T)
        where T: AutoCloseable,
              T: Appendable {
    input.append("there")
    input.close()
}
writer = java.io.StringWriter()
writer.append("hello ")
useAndCloseMultipleTypes(writer)
println(writer) // hello there