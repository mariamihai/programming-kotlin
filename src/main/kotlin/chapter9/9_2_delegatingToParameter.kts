package chapter9

interface Worker {
    fun work()
    fun takeVacation()
}

class JavaProgrammer : Worker {
    override fun work() = println("...write Java...")
    override fun takeVacation() = println("...code at the beach...")
}
class CSharpProgrammer : Worker {
    override fun work() = println("...write C#...")
    override fun takeVacation() = println("...branch at the ranch...")
}

class Manager(val staff: Worker): Worker by staff {
    fun meeting() =
        println("Organizing meeting with ${staff.javaClass.simpleName}")

    override fun takeVacation() = println("of course")
}

val doe = Manager(CSharpProgrammer())
val roe = Manager(JavaProgrammer())

doe.work() // ...write C#...
doe.takeVacation() // of course
doe.meeting() // organizing meeting with CSharpProgrammer

roe.work() // ...write Java...
roe.takeVacation() // of course
roe.meeting() // organizing meeting with JavaProgrammer