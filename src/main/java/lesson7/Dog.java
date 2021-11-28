package lesson7;

public class Dog {
    private String name;
    private final int runDistance = 500;
    private final int swimDistance = 10;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void doRun(int distance) {
        if (distance <= 0) {
            System.out.println("Введите значение больше нуля!");
        } else if (distance <= this.runDistance) {
            System.out.println(this.name + " пробежал " + distance + " метров.");
        } else {
            System.out.println(this.name + " может бегать только на " + this.runDistance);
        }
    }

    public void doSwim(int distance) {
        if (distance <= 0) {
            System.out.println(this.name + " не умеет плавать.");
        } else if (distance <= this.swimDistance) {
            System.out.println(this.name + " проплыл " + distance + " метров.");
        } else {
            System.out.println(this.name + " может плыть только на " + this.swimDistance);
        }
    }
}
