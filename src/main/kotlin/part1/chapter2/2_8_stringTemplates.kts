package part1.chapter2

// $variable; ${expression}; $${} - first $ is a literal;
// $ - used as literal; \$ - escape it to use it as a literal

val price = 12.25
val taxRate = 0.08

val output = "The amount $price after tax comes to $${price * (1 + taxRate)}."
val disclaimer = "The amount is in US$, that's right in \$only."

println(output)
println(disclaimer)