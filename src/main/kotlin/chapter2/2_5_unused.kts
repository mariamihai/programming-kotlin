// RUn with -Werror option to fail the build or execution (treat warnings
// as errors): kotlinc-jvm -Werror -script 2_5_unused.kts

// The next warning is displayed when running without that option:
// warning: parameter 'n' is never used

fun compute(n: Int) = 0

println(compute(4))