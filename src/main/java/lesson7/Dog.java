package lesson7;

public class Dog {
    String name;
    int run;
    int swim;

    public void setRun() {
        if (run <= 0) {
            System.out.println(name + " не умеет бегать");
        } else {
            System.out.println(name + " пробежал " + run + " метров.");
        }
    }

    public void setSwim() {
        if (swim <= 0) {
            System.out.println(name + " не умеет плавать.");
        } else {
            System.out.println(name + " проплыл " + swim + " метров.");
        }
    }
}
