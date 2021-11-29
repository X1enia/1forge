package lesson7;

public class Gazelle {
    private String name;
    private static final int RUN_DISTANCE = 2000;
    private static final int SWIM_DISTANCE = 3;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void doRun(int distance) {
        if (distance <= 0) {
            System.out.println("Введите значение больше нуля!");
        } else if (distance <= RUN_DISTANCE) {
            System.out.println(this.name + " пробежала " + distance + " метров.");
        } else {
            System.out.println(this.name + " может бегать только на " + RUN_DISTANCE);
        }
    }

    public void doSwim(int distance) {
        if (distance <= 0) {
            System.out.println("Введите значение больше нуля!");
        } else if (distance <= SWIM_DISTANCE) {
            System.out.println(this.name + " проплыла " + distance + " метра.");
        } else {
            System.out.println(this.name + " может плыть только на " + SWIM_DISTANCE);
        }
    }
}
