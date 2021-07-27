package chapter7

import chapter7.topLevelFunctions._7_2_topLevelFunctions.*
import chapter7.topLevelFunctions._7_2_topLevelFunctions.Temperature.c2f

fun main() {
//    println(unitsSupported())
    println(Temperature.f2c(75.253))
    println(c2f(24.305))
}

// Place functions at the top-level and use singletons to group and
// modularize functions further, based on application needs.