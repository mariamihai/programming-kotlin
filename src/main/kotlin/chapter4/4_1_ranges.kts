package chapter4

val oneToFive: IntRange = 1..5

val aToE: CharRange = 'a'..'e'

// Create a range from hell to help, changing the last character with letters from l to p
val seekHelp: ClosedRange<String> = "hell".."help"
println(seekHelp.contains("helm")) // true
println(seekHelp.contains("helq")) // false
println(seekHelp)