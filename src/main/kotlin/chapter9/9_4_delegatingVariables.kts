package chapter9

import kotlin.reflect.KProperty

class PoliteString(var content: String) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>) =
        content.replace("stupid", "s*****")

    operator fun setValue(thisRef: Any, property: KProperty<*>, value:String) {
        content = value
    }

//    fun beingPolite(content: String) = PoliteString(content)
}

var comment: String by PoliteString("Some nice message")
// Can use instead: var commentPolite: String by beingPolite("Some nice message")
println(comment)

comment = "This is stupid"
println(comment)

println("comment is of length: ${comment.length}")

// Eg., of compiling and executing this example, with different packages:
// kotlinc-jvm com/agiledeveloper/delegates/PoliteString.kt -d polite.jar
// kotlinc-jvm -classpath polite.jar -script politecomment.kts