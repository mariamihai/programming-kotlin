package part1.chapter5

val names = listOf("Tom", "Jerry")

for((index, name) in names.withIndex())
    println("$index $name")
// 0 Tom
// 1 Jerry