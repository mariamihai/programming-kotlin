package chapter9

import kotlin.properties.Delegates.vetoable

var count by vetoable(0) { _, oldValue, newValue -> newValue > oldValue }

println("The value of count is: $count")

count++
println("The value of count is: $count")

// Changes to count are not accepted => count remains 1
count--
println("The value of count is: $count")
