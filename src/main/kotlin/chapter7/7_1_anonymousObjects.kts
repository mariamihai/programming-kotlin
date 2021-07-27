package chapter7

// Object expression - will create an instance of an anonymous inner class

fun drawCircle() {
    val circle = object {
        val x = 10
        val y = 20
        val radius = 30
    }

    println("Circle x: ${circle.x} y: ${circle.y} radius: ${circle.radius}") // Circle x: 10 y: 20 radius: 30
}

drawCircle()


// With declared object type
fun createRunnable(): Runnable {
    return object : Runnable {
        override fun run() {
            println("You called...")
        }
    }
}
val aRunnable = createRunnable()
aRunnable.run() // You called...


fun createRunnableInline(): Runnable = Runnable { println("You called...") }


// The return type needs to be set in this case
fun createRunnableMultipleImplementations(): Runnable = object: Runnable, AutoCloseable {
    override fun run() { println("You called...") }
    override fun close() { println("closing...") }
}
val anotherRunnable = createRunnableMultipleImplementations()
anotherRunnable.run() // You called...
//anotherRunnable.close() // Error: Unresolved reference: close



// Object statement or declaration - will create a singleton
// Eg., Unit is a singleton

object Util {
    fun numberOfProcessors() = Runtime.getRuntime().availableProcessors()
}
println(Util.numberOfProcessors())
// Internally, Kotlin represents the singleton object as a static instance of an Util class
// The method itself isn’t static in the bytecode unless the @JvmStatic annotation is used


object Sun : Runnable {
    val radiusInKM = 696000
    var coreTemperatureInC = 15000000
    override fun run() { println("spin...") }

    fun abc() {println("abc")}
}
fun moveIt(runnable: Runnable) {
    runnable.run()
}
println(Sun.radiusInKM) // 696000
moveIt(Sun) // spin...
Sun.abc() // abc
