package lesson8;

public class Dog extends AbstractAnimal {
    private static String VOICE = "гав";

    public Dog(String name) {
        this.setName(name);
    }

    @Override
    public void doSound() {
        System.out.println(this.getName() + " говорит: " + VOICE);
    }
}
