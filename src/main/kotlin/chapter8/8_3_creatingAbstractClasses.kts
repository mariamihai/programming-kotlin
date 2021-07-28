package chapter8

// abstract keyword has to be set for abstract methods or classes

abstract class Musician(val name: String, val activeFrom: Int) {
    abstract fun instrumentType(): String
}

class Cellist(name: String, activeFrom: Int) : Musician(name, activeFrom) {
    override fun instrumentType() = "String"
}

val ma = Cellist("Yo-Yo Ma", 1961)
println(ma.instrumentType())

// The properties defined within interfaces don't have backing fields
// while the ones within abstract classes can use backing fields.