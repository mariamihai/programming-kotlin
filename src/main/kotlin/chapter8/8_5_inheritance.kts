// Kotlin classes are final by default. Need to specify open to
// be able to inherit from them.

// An overriding method may be marked final override to prevent a
// subclass from further overriding that method.

// A val property in the base may be overridden with a val or var in
// the derived.
// A var property in the base may be overridden only using var in the
// derived.

open class Vehicle(val year: Int, open var color: String) {
    open val km = 0

    final override fun toString(): String = "year: $year, color: $color, KM: $km"

    // final method as it's not marked as open
    fun repaint(newColor: String) {
        color = newColor
    }
}

open class Car(year: Int, color: String): Vehicle(year, color) {
    override var km: Int = 0
        set(value) {
            if(value < 1) {
                throw RuntimeException("Can't set negative value.")
            }

            field = value
        }

    fun drive(distance: Int) {
        km += distance
    }
}

val car = Car(2019, "Orange")
println(car.year) // 2019
println(car.color) // Orange

car.drive(10)
println(car) // year: 2019, Color: Orange, KM: 10

try {
    car.drive(-30)
} catch(ex: RuntimeException) {
    println(ex.message) // Can't set negative value.
}


class FamilyCar(year: Int, color: String): Car(year, color) {
    override var color: String
        get() = super.color
        set(value) {
            if(value.isEmpty()) {
                throw RuntimeException("Color required.")
            }

            super.color = value
        }
}


val familyCar = FamilyCar(2019, "Green")
println(familyCar.color) // Green

try {
    familyCar.repaint("")
} catch(ex: RuntimeException) {
    println(ex.message) // Color required.
}


// You can be more generous with the access restrictions, but
// not stricter.