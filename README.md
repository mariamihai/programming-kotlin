# Programming Kotlin

My implementation based on the [book](https://www.oreilly.com/library/view/programming-kotlin/9781680507287/) by Venkat Subramaniam.

- [Initial details](#initial-details)
- [Implementation](#implementation)
  - [Chapter 1](#chapter-1)
    - [Installing and compiling the code](#installing-and-compiling-the-code)
    - [REPL](#repl)
    - [Scripts](#scripts)
  - [Chapter 2](#chapter-2)
    - [Less typing](#less-typing)
    - [Warnings](#warnings)
    - [Immutability](#immutability)
    - [Equality checks](#equality-checks)
    - [Strings](#strings)
      - [String templates](#string-templates)
      - [Raw Strings](#raw-strings)
      - [Multiline Strings](#multiline-strings)
  - [Chapter 3](#chapter-3)
    - [Types](#types)
    - [Parameters](#parameters)
    - [vararg, spread and destructuring](#vararg-spread-and-destructuring)
  - [Chapter 4](#chapter-4)
    - [Ranges](#ranges)
    - [Iterations](#iterations)
    - [Iterations over lists and arrays](#iterations-over-lists-and-arrays)
    - [Using `when`](#using-when)
  
## Initial details

I am using GitPod for current project. More details on how to use Kotlin in GitPod can be found [here](https://www.gitpod.io/docs/languages/kotlin/).


## Implementation

### Chapter 1
***
***

Initial run of a Kotlin application was done based on [Create and run an application](https://kotlinlang.org/docs/command-line.html) example.

- verify the installation: `kotlinc-jvm -version`

---
#### Installing and compiling the code

Created a `Hello, world!` example under `/chapter1`
- compiling the code into Java bytecode in CLI: `kotlinc-jvm chapter1/hello.kt -d chapter1/hello.jar`
    - `-d` - to indicate the output path (directory or `.jar` file)
    - `-include-runtime` - the outputed `.jar` file will be self-contained and runnable by including the Kotlin runtime library in it 
- running the code: `java -classpath chapter1/hello.jar HelloKt`
    - the Kotlin compiler creates a class named after the file name and adds the `Kt` suffix
- the output will be of course: `Hello, World!`
- can be run with `java -jar chapter1/hello.jar` as the Kotlin compiler will add the Main-Class manifest attribute to the jar file

- using Kotlin standard library:
```bash
kotlinc-jvm Hello.kt -d Hello.jar
java -classpath Hello.jar:$KOTLIN_PATH/lib/kotlin-stdlib.jar HelloKt
```

- using the `kotlin` tool (don't need to refer to `kotlin-stdlib.jar` this way):
```bash
kotlinc-jvm Hello.kt -d Hello.jar
kotlin -classpath Hello.jar HelloKt
```

---
#### REPL

For interactive sessions type `kotlinc-jvm`. To terminate the REPL session use `ctrl+d` / `ctrl+c` or type `:quit`.

```
$ kotlinc-jvm
Picked up JAVA_TOOL_OPTIONS: -Xmx1879m
Welcome to Kotlin version 1.5.0 (JRE 11.0.10+9-LTS)
Type :help for help, :quit for quit
>>> :load Hello.kt
>>> main()
Hello, World!
```

---
#### Scripts

Run a script (the file has `.kts` extension): `kotlinc-jvm -script chapter1/listktsfiles.kts`.

On Unix-like systems you can add Bash shebang to the script file `#!/usr/bin/env kotlinc-jvm -script`, make the scrip executable (`chmd +x script.kts`) and then run it (`./script.kts`)

### Chapter 2
***
***

Essential Kotlin elements compared to Java code.

---
#### Less typing

Semicolons, variable type specifications, classes, functions and try-catches are optional

---
#### Warnings

Treat warnings as errors with the `-Werror` option: 
```bash
kotlinc-jvm -Werror -script script.kts
```

---
#### Immutability

Prefer immutability (with `val`) instead of changing variables (with `var`).
```kotlin
val pi: Double = 3.14
```

---
#### Equality checks

Kotlin has 2 types of equality checks:
- structural equality: `==` (same as `equals()` in Java)
  
(take into consideration that Kotlin handles nulls safety)
- referential equality: `===` (same as `==` in Java))

---
#### Strings

##### String templates

Example of `$` use:
```
$variable
${expression}
$${complex - expression} // first $ is a literal
US$ // used as literal - US$
\$US // escape it to use it as a literal - $US
```

##### Raw Strings

Use escaped Strings for small, simple, plain vanilla Strings:
```kotlin
val escaped = "The kid asked, \"How's it going, $name?\""
val raw = """The kid asked, "How's it going, $name?""""
```

##### Multiline Strings

```kotlin
val multilineWithIndentation = """The kid asked,
    "How's it going, $name?""""
println(multilineWithIndentation)
//The kid asked, 
//  "How's it going, Maria?"

val multilineWithoutIndentation = """The kid asked,
    |"How's it going, $name?"""".trimMargin()
println(multilineWithoutIndentation)
//The kid asked, 
//"How's it going, Maria?"

val multilineWithoutIndentation2 = """The kid asked,
    ~"How's it going, $name?"""".trimMargin("~")
println(multilineWithoutIndentation2)
//The kid asked, 
//"How's it going, Maria?"
```

### Chapter 3
***
***

Working with functions in Kotlin.

---
#### Types

The parameter types need to be specified but the return type can be inferred.

The equivalent of Java's `void` is `Unit`.

```kotlin
fun sayHelloInferredType() = println("Well, hello")

fun sayHelloSpecifiedType(): Unit = println("Well, hello")
```

Single line functions can omit braces.

```kotlin
fun sayHelloOmittedBraces() = println("Well, hello")

fun sayHelloOmittedBracesWithType(): Unit {
  println("Well, hello")
}

fun sayHelloOmittedBracesWithoutType() {
  println("Well, hello")
}
```

---
#### Parameters

Default or named parameters can be used.

```kotlin
fun greet(name : String, message: String = "Hello"): String {
    return "$message, $name"
}

println(greet("Maria"))
println(greet(name = "Maria"))
println(greet(message = "Hey", name = "Maria"))
```

---
#### vararg, spread and destructuring

Examples:

```kotlin
fun greetMany(message: String, vararg names: String) {
    println("$message ${names.joinToString(", ")}")
}
greetMany("Hello", "Tom", "Jerry", "Spike")
```

Use `*` for spreading the values.

```kotlin
println(max(*values))
```

Can extract values from an object. The destructuring in Kotlin is based on the position of properties instead 
of the names of the properties.

```kotlin
fun getFullName() = Triple("John", "Quincy", "Adams")

val (first, middle, last) = getFullName()
val (first, _, last) = getFullName()
val (_, _, last) = getFullName()
val (_, middle) = getFullName()
```

### Chapter 4
***
***

External iteration and argument matching utilizing ranges and `when`.

---
#### Ranges

```kotlin
val oneToFive: IntRange = 1..5
val aToE: CharRange = 'a'..'e'
val seekHelp: ClosedRange<String> = "hell".."help"
```

---
#### Iterations

Forward and reverse iterations are easier to implement in Kotlin, but you can't iterate like this over 
`ClosedRange<T>` constants like `seekHelp`.

```kotlin
for (i in 1..5) { print("$i, ") }
for (ch in 'a'..'e') { print(ch) }
for (i in 5 downTo 1) { print("$i, ") }
```

Can skip last value.

```kotlin
for (i in 1 until 5) { print("$i, ") } // [1, 5)
```

And have a specific step.

```kotlin
for (i in 1 until 10 step 3) { print("$i, ") }
for (i in 10 downTo 0 step 3) { print("$i, ") }
```

This is a preferred way of iteration than Java's `i = i + step` as it
ensures immutability.

---
#### Iterations over lists and arrays

```kotlin
val array = arrayOf(1, 2, 3)
for (a in array) { print("$a, ") }

val list = listOf(1, 2, 3)
for (l in list) { print("$l, ") }
```

Can utilize the index and get both the index and the value with destructuring:

```kotlin
val names = listOf("Tom", "Jerry", "Spike")
for (index in names.indices) {
    println("Position of ${names.get(index)} is $index")
}

for ((index, name) in names.withIndex()) {
    println("Position of $name is $index")
}
```

---
#### Using `when`

`When` can be used both as a statement or as an expression.

Using it as an expression:

```kotlin
fun bigNmberCheck(number: Int) = when {
    number > 1000 -> "It's a huge number"
    number > 100 -> "It's a big number"
    number > 0 -> "It's a positive number"
    else -> "it's something"
}
```

Using `when` as a statement without the `else` branch:

```kotlin
fun printWhatToDo(dayOfWeek: Any) {
    when (dayOfWeek) {
        "Saturday", "Sunday" -> println("Relax")
        in listOf("Monday", "Tuesday", "Wednesday", "Thursday") ->
            println("Work hard")
        in 2..4 -> println("Work hard")
        "Friday" -> println("Party")
        is String -> println("What?")
    }
}
```

Can use variables with limited scope:

```kotlin
fun systemInfoWithLimitedScope(): String {
    return when (val numberOfCores = Runtime.getRuntime().availableProcessors()) {
        1 -> "1 core, packing this one to the museum"
        in 2..16 -> "You have $numberOfCores cores"
        else -> "$numberOfCores cores!, I want your machine"
    }
}
```

### Chapter 5
***
***

Using collections. Kotlin prefers the immutable favor, and these collections serve 
as views to Java collections. Mutable collections are declared and not implied. They 
are preferred in simple, single threaded apps.

---
#### Existing collections
* Pair - tuple of two values <br>
* Triple - a tuple of three values <br>
* Array - indexed fixed-sized collection of objects and primitives <br>
* List - ordered collection of objects <br>
* Set - unordered collection of objects <br>
* Map - associative dictionary or map of keys and values <br>`

---
#### Pair and Triple

Examples of `Pairs` of `Strings`:
```kotlin
println(Pair("Tom", "Jerry")) // (Tom, Jerry)
println(mapOf("Tom" to "Cat", "Jerry" to "Mouse")) // {Tom=Cat, Jerry=Mouse}
```

To obtain the values from the `Pairs` we can use the `first` and `second` properties:
```kotlin
for (character in animation) {
    println("Name: ${character.first}: Animal type: ${character.second}")
}

```

---
#### Arrays of objects and primitives

```kotlin
val people = arrayOf("Person 1", "Person 2", "Person 3")
println(people::class) // class kotlin.Array - the type in Kotlin - Array<T>
println(people.javaClass) // class [Ljava.lang.String; - the underlying type
println("${people[0]} and ${people[1]}") //Person 1 and Person 2

```

There are specialized functions based on the type needed:
```kotlin
val numbers = intArrayOf(1, 2, 3)
println(numbers::class) // class kotlin.IntArray
println(numbers.javaClass) // class [I
```

---
#### Lists

Immutability is implicit in `listOf()`. To declare a mutable list you 
need to specify it - `mutableListOf()`

```kotlin
val fruits: List<String> = listOf("Apple", "Banana", "Grape")
println(fruits) // [Apple, Banana, Grape]
println(fruits::class) // class java.util.Arrays$ArrayList
println(fruits.javaClass) // class java.util.Arrays$ArrayList
```

Accessing a particular element with:
```kotlin
println("first's ${fruits[0]}, that's ${fruits.get(0)}")
```

Check if an element is present:
```kotlin
println(fruits.contains("Apple")) // true
println("Apple" in fruits) // true
```

Use the `+` and `-` operators to create new lists:
```kotlin
val withOrange = fruits + "Orange"

println(fruits) //[Apple, Banana, Grape]
println(withOrange) //[Apple, Banana, Grape, Orange]

val noBanana = fruits - "Banana"
println(noBanana) //[Apple, Grape]
```

Prefer using `listOf()` instead of `mutableListOf()` or `arrayListOf()`.

---
#### Sets

There are both immutable and mutable versions - `setOf()` and `mutableSetOf()`. 
For specific implementations use `hashSetOf()`, `linkedSetOf()` or `sortedSetOf()`.
```kotlin
val fruits: Set<String> = setOf("Apple", "Banana", "Apple")
println(fruits) //[Apple, Banana]
println(fruits::class) //class java.util.LinkedHashSet
println(fruits.javaClass) //class java.util.LinkedHashSet
```

---
#### Maps
Immutable and mutable versions available - `mapOf()`, `mutableMapOf()`. For 
specific implementations use - `hashMapOf()`, `linkedMapOf()` or `sortedMapOf()`.
```kotlin
val sites = mapOf("pragprog" to "https://www.pragprog.com",
                  "agiledeveloper" to "https://agiledeveloper.com")
println(sites.size) // 2

println(sites.containsKey("agiledeveloper")) // true
println(sites.containsValue("http://www.example.com")) // false
println(sites.contains("agiledeveloper")) // true
println("agiledeveloper" in sites) // true
```

To obtain one of the elements:
```kotlin
val pragProgSite: String? = sites.get("pragprog")
val pragProgSite2: String? = sites["pragprog"]
val agiledeveloper =
sites.getOrDefault("agiledeveloper", "http://www.example.com")
```

Create new maps using the `+` and `-` operators.

Iteration over the elements of the map:
```kotlin
for (entry in sites) {
    println("${entry.key} --- ${entry.value}")
}

// or

for ((key, value) in sites) {
  println("$key --- $value")
}
```