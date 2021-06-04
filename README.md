# Programming Kotlin

My implementation based on the book by Venkat Subramaniam.

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

```kotlin
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