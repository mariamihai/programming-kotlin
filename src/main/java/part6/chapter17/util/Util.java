package part6.chapter17.util;

public class Util {
    public double f2c(double fahrenheit) {
        return (fahrenheit - new Constant().getFreezingPointInF()) * 5 / 9.0;
    }
}
