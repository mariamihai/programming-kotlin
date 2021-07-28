package chapter9

import kotlin.properties.Delegates.observable

// The singleton object kotlin.properties.Delegates has an observable()
// convenience function to create a ReadWriteProperty delegate that
// will intercept any change to the variable or property it’s associated
// with. When a change occurs, the delegate will call an event handler
// you register with the observable() function.

var count by observable(0) { property, oldValue, newValue ->
    println("Property: $property old: $oldValue: new: $newValue")
}

println("The value of count is: $count")

count++
println("The value of count is: $count")

count--
println("The value of count is: $count")
