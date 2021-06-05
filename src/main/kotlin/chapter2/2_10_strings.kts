val name = "Maria"
val escaped = "The kid asked, \"How's it going, $name?\""

val raw = """The kid asked, "How's it going, $name?""""
val multilineWithIndentation = """The kid asked, 
    "How's it going, $name?""""
println(multilineWithIndentation)
val multilineWithoutIndentation = """The kid asked, 
    |"How's it going, $name?"""".trimMargin()
println(multilineWithoutIndentation)
val multilineWithoutIndentation2 = """The kid asked, 
    ~"How's it going, $name?"""".trimMargin("~")
println(multilineWithoutIndentation2)