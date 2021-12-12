package lesson11;

public abstract class Automobile {
    private int number;
    private double speed;
    private double weigh;
    private double height;
    private double width;
    private double length;
    private AutoType autoType;

    public Automobile(int number, double speed, double weigh, double height, double width, double length, AutoType autoType) {
        this.number = number;
        this.speed = speed;
        this.weigh = weigh;
        this.height = height;
        this.width = width;
        this.length = length;
        this.autoType = autoType;
    }

    public int getNumber() {
        return number;
    }

    public double getSpeed() {
        return speed;
    }

    public double getWeigh() {
        return weigh;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public AutoType getAutoType() {
        return autoType;
    }
}
