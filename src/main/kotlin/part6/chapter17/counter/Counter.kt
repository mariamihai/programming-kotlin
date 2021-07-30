@file:JvmName("CounterTop")
package part6.chapter17.counter

import kotlin.jvm.JvmStatic

fun createCounter() = Counter(0)

data class Counter(val value: Int) {
    operator fun plus(other: Counter) = Counter(value + other.value)

    fun map(mapper: (Counter) -> Counter) = mapper(this)

    @Throws(java.io.FileNotFoundException::class)
    fun readFile(path: String) = java.io.File(path).readLines()

    @JvmOverloads
    fun add(n: Int = 1) = Counter(value + n)

    companion object {
        @JvmStatic
        fun create() = Counter(0)
    }

}