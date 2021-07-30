package part1.chapter6

// <*> - specifies both generic read-only types  and raw  types
// It gives type safety when not enough is known about the type
// It permits only read-out and not write-in

fun printValues(values: Array<*>) {
    for (value in values) {
        print("$value ")
    }

    //values[0] = values[1] // ERROR
}
printValues(arrayOf(1, 2)) // 1 2

// Can be used with covariance - it is the equivalent of <out T>

// Can be used with contravariance - if the parameter is defined in the
// declaration-site variance as <in T> then it is equivalent to
// in Nothing (writing anything will result in a compilation error)