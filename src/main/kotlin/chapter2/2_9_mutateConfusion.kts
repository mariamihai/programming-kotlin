var factor = 2

// The variable factor in doubleIt binds to the variable outside its
// immediate scope and uses the value at the time of the function call
fun doubleIt(n: Int) = n * factor

// This is evaluated when the variable is created - factor will be 2
var message = "The factor is $factor"

factor = 0
println(doubleIt(2))
println(message)

factor = 10
println(doubleIt(2))
