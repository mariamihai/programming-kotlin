package part1.chapter6

class Animal {
    override operator fun equals(other: Any?) = other is Animal
}

val greet: Any = "hello"
val odie: Any = Animal()
val toto: Any = Animal()

println(odie == greet) // false
println(odie == toto) // true
