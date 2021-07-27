// Kotlin nested classes can't access the private members of the
// nesting outer class.
// If marked with the inner keyword, the restriction goes aw


interface Remote {
    fun up()
    fun down()

    // Equivalent to default methods in Java
    fun doubleUp() {
        up()
        up()
    }

//    companion object {
//        fun combine(first: Remote, second: Remote): Remote = object: Remote {
//            override fun up() {
//                first.up()
//                second.up()
//            }
//
//            override fun down() {
//                first.down()
//                second.down()
//            }
//        }
//    }
}


class TV {
    private var volume = 0

    val remote: Remote
        get() = TVRemote()

    override fun toString(): String = "Volume: $volume"

    inner class TVRemote: Remote {
        override fun up() {
            volume++
        }

        override fun down() {
            volume--
        }

        // Eg., the toString() of Any: super@TV.toString()
        // (ask for the base class of the outer class)
        // => design smell
        override fun toString(): String = "Remote: ${this@TV.toString()}"
    }

    // Can use an anonymous inner class instead
//    val remoteAnonymous : Remote get() = object: Remote {
//        override fun up() {
//            volume++
//        }
//
//        override fun down() {
//            volume--
//        }
//
//        override fun toString() = "Remote: ${this@TV.toString()}"
//    }
}


val tv = TV()
val remote = tv.remote

println("$tv") // Volume: 0
remote.up()
println("After increasing: $tv") // After increasing: Volume: 1
remote.doubleUp()
println("After doubleUp: $tv") // After doubleUp: Volume: 3

println(remote) // Remote: Volume: 3