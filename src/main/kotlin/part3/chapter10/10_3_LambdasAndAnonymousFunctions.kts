package part3.chapter10

val names = listOf("Pam", "Pat", "Paul", "Paula")
val checkLength5 = { name: String -> name.length == 5 }
// val checkLength5: (String) -> Boolean = { name -> name.length == 5 }
println(names.find(checkLength5)) // Paula

// Specify the type of the variable if you’d like to convey and enforce
// the return type of the lambda.
// Specify the type of the lambda parameters if you want the return
// type to be inferred.

// Can convert it to an anonymous function:
val checkLength5Func = fun(name: String): Boolean { return name.length == 5 }

names.find(fun(name: String): Boolean {return name.length == 5})

// Prefer lambdas over anonymous functions.