package lesson7;

public class Cat {
    private String name;
    private final int runDistance = 200;

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
        System.out.println(getName() + " не умеет плавать");
    }
}