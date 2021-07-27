package chapter7

class Car (val yearOfMake: Int)
//public class Car public constructor(public val yearOfMake: Int)

val car = Car(2021)
println(car.yearOfMake) // 2021


class CarWithColor(val yearOfMake: Int, var color: String)
val carWithColor = CarWithColor(2021, "Pink")
carWithColor.color = "Purple"
println(carWithColor.color) // Purple

// car.yearOfMake = car.getYearOfMake()

// color cannot be null as it is a String and not a String? type


// Compile the code and check the bytecode using the javap tool:
// kotlinc-jvm CarWithColor.kt
// javap -p CarWithColor.class

// Compiled from "CarWithColor.kt"
//public final class CarWithColor {
//    private final int yearOfMake;
//    private java.lang.String color;
//    public final int getYearOfMake();
//    public final java.lang.String getColor();
//    public final void setColor(java.lang.String);
//    public CarWithColor(int, java.lang.String);
//}