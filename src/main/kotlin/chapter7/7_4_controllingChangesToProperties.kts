package chapter7

// theColor is a parameter, not a field
class Car(val yearOfMake: Int, theColor: String) {
    // Property of the class, Kotlin synthesizes a getter and a setter
    // for this property
    var fuelLevel = 100

    // Property of the class, assigned theColor parameter value to it
    // theColor could have been named color and the assignation would
    // have been - var color = color; equivalent to this.color = color
    // Kotlin only synthesizes a getter and uses the setter provided
    // in code
    var color = theColor
        set(value) {
            if(value.isBlank()) {
                throw RuntimeException("Can't be empty")
            }

            // field - special keyword, can be used only in setters
            // and getters
            field = value
        }
}

val car = Car(2021, "Red")
car.color = "Green"
car.fuelLevel--

println(car.fuelLevel) // 99
try {
    car.color = ""
} catch(ex: Exception) {
    println(ex.message) // Can't be empty
}
// The previous color value is used as it wasn't modified
println(car.color) // Green