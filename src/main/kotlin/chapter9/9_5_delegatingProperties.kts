package chapter9

import kotlin.reflect.KProperty

class PoliteString (val dataSource: MutableMap<String, Any>) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>) =
        (dataSource[property.name] as? String)?.replace("stupid", "s*****") ?: ""

    operator fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        dataSource[property.name] = value
    }
}

class PostComment(dataSource: MutableMap<String, Any>) {
    val title: String by dataSource
    var likes: Int by dataSource
    var comment: String by PoliteString(dataSource)

    override fun toString() = "Title: $title Likes: $likes Comment: $comment"
}

val data0: MutableMap<String, Any> =
    mutableMapOf(
        "title" to "Using Delegation",
        "likes" to 2,
        "comment" to "Keep it simple, stupid")
val data1: MutableMap<String, Any> =
    mutableMapOf(
        "title" to "Using Inheritance",
        "likes" to 1,
        "comment" to "Prefer Delegation where possible")

val forPost1 = PostComment(data0)
val forPost2 = PostComment(data1)
forPost1.likes++
println(forPost1)

forPost1.comment = "stupid"
println(forPost1)

println(forPost2)
