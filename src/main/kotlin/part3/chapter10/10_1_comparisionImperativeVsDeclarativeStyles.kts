package part3.chapter10

// Imperative style - what + how
var doubleOfEvenImp = mutableListOf<Int>()
for (i in 1..10) {
    if (i % 2 == 0) {
        doubleOfEvenImp.add(i * 2)
    }
}
println(doubleOfEvenImp) // [4, 8, 12, 16, 20]

// Declarative style - what, not how
// Functional style - declarative style + higher-order functions
val doubleOrEvenFunc = (1..10)
    .filter { e -> e % 2 == 0 }
    . map { e -> e * 2}
println(doubleOrEvenFunc) // [4, 8, 12, 16, 20]