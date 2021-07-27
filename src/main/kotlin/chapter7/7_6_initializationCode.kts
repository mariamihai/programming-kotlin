package chapter7

// A class may have zero or more init blocks executed as part of the
// primary constructor execution
// Within an init block only the properties that are already defined
// above the block can be accessed
class Car(val yearOfMake: Int, theColor: String) {
    var fuelLevel = 100
        private set

    var color = theColor
        set(value) {
            if (value.isBlank()) {
                throw RuntimeException("Can't be empty")
            }
            field = value
        }

    init {
        if (yearOfMake < 2020) {
            fuelLevel = 90
        }
    }

    // Can be set at the definition of fuelLevel instead of using
    // the init block:
    // var fuelLevel = if (yearOfMake < 2020) 90 else 100
    //      private set
}