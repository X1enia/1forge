package lesson11;

public class Car extends Automobile {
    public Car(String number, double speed, double weigh, double height, double width, double length, AutoType autoType) {
        super(number, speed, weigh, height, width, length);
        this.setAutoType(autoType);
    }
}
