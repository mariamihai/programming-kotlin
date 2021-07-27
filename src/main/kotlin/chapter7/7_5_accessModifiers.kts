package chapter7

// Available access modifiers:
// - public, private - same as in Java
// - protected - gives permission to the methods of the derived class
// to access that property
// - internal - gives permission for any code in the same module to
// access the property or method (doesn't have a direct bytecode
// representation)

// The access permission for the getter is the same as that for the
// property. A different one can be provided for the setter.

// Eg., change the access for fuelLevel to be only from within the class
// var fuelLevel = 100
//      private set