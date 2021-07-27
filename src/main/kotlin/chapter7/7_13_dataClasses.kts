package chapter7

// They are intended to carry mostly data rather than behavior.
// The primary constructor is required to define at least one property,
// using val or var.
// Non-val or var parameters aren't allowed.
// Other properties or methods can be added.

// Kotlin automatically creates the equals(), hashCode() and toString()
// methods.
// It adds a copy() method, and components methods - component1(), etc.

data class Task(val id: Int, val name: String,
                val completed: Boolean, val assigned: Boolean)


val task1 = Task(1, "Create Project", false, true)
println(task1)
    // Task(id=1, name=Create Project, completed=false, assigned=true)
println("Name: ${task1.name}") // Name: Create Project


// The copy() method includes all the properties, not only the ones
// in the primary constructor.
// It performs a shallow copy of primitives and references.
val task1Completed = task1.copy(completed = true, assigned = false)
println(task1Completed)
    // Task(id=1, name=Create Project, completed=true, assigned=false)


// Destructuring
val (id, _, _, isAssigned) = task1
println("Id: $id Assigned: $isAssigned") //Id: 1 Assigned: true

// Use a data class when:
// - you're modeling data more than behavior
// - you want generated equals(), hasCode(), toString(), and / or copy()
// - the primary constructor takes at least one property
// - the primary constructor takes only properties
// - you want to extract data easily from the object via destructuring