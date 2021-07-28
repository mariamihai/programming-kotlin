package chapter9

import kotlin.random.Random

// The Lazy delegate - defer creating objects or executing computations
// until the time the result is truly needed.

fun getTemperature(city: String): Double {
    print("fetch from webservice for $city => ")
    return 30.0
}

for( i in 1..3) {
    var showTemperature = Random.nextBoolean()

    // The lambda expression is not reevaluated, the delegate memoizes
    // the result
    // Can use LazyThreadSafetyMode for different synchronization
    // options
    val temperature by lazy { getTemperature("Gothenburg") }

    print("$showTemperature - ")

    // getTemperature() is called here, after showTemperature = true
    if (showTemperature && temperature > 20) //(nothing here)
        println("Warm")
    else
        println("Nothing to report") //Nothing to report

}