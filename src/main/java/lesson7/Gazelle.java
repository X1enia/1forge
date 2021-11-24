package lesson7;

public class Gazelle {
    String name;
    int run;
    int swim;

    public void setRun() {
        if (run <= 0) {
            System.out.println(name + " не умеет бегать");
        } else {
            System.out.println(name + " пробежала " + run + " метров.");
        }
    }

    public void setSwim() {
        if (swim <= 0) {
            System.out.println(name + " не умеет плавать.");
        } else {
            System.out.println(name + " проплыла " + swim + " метров.");
        }
    }
}
