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

