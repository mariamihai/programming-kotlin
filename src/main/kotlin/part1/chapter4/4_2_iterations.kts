package part1.chapter4

println("*** Forward iteration ***")

for (i in 1..5) { print("$i, ") } // 1, 2, 3, 4, 5,
// i is a val with limited scope

println()
for (ch in 'a'..'e') { print(ch) } // abcde

// Can't iterate like this over ClosedRange<T>
//for (word in "hell".."help") { print("$word, ") }
// ERROR - for-loop range must have an 'iterator()' method


println("\n\n*** Reverse iteration ***")
for (i in 5.downTo(1)) { print("$i, ") } // 5, 4, 3, 2, 1,

println()
for (i in 5 downTo 1) { print("$i, ") } // 5, 4, 3, 2, 1,