package chapter9.moreOnDelegation

// https://en.wikipedia.org/wiki/Delegation_pattern
// https://en.wikipedia.org/wiki/Delegation_(object-oriented_programming)

// The delegation pattern is an OO design pattern that allows object
// composition to achieve the same code reuse as inheritance.
// Delegation refers to evaluating a member of one object (the receiver)
// in the context of another original object (the sender).

// An object handles a request by delegating to a second object (THE DELEGATE).
// The delegate is a helper obj but with the original context.

class Rectangle(val width: Int, val height: Int) {
    fun area() = width * height
}

class Window (val bounds: Rectangle) {
    // Delegation
    fun area() = bounds.area()
}




interface ClosedShape {
    fun area(): Int
}

class RectangleShape(val width: Int, val height: Int) : ClosedShape {
    override fun area() = width * height
}

class WindowWithClosedShape(private val bounds: ClosedShape): ClosedShape by bounds