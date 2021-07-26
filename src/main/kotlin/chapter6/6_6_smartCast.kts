package chapter6

class Animal(val age: Int) {
//    override operator fun equals(other: Any?): Boolean {
//        return if (other is Animal) age == other.age else false
//    }

    override operator fun equals(other: Any?) =
        other is Animal && age == other.age
}

val odie = Animal(2)
val toto = Animal(2)
val butch = Animal(3)

println(odie == toto) // true
println(odie == butch) // false


fun whatToDo(dayOfWeek: Any) = when (dayOfWeek) {
    "Saturday", "Sunday" -> "Relax"
    in listOf("Monday", "Tuesday", "Wednesday", "Thursday") -> "Work hard"
    in 2..4 -> "Work hard"
    "Friday" -> "Party"
    // No need to cast dayOfWeek to String, by checking "is String"
    // Kotlin knows to cast so you can use String's methods
    is String ->  "What, you provided a string of length ${dayOfWeek.length}"
    else -> "No clue"
}
