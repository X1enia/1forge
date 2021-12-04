package lesson8;

public class Rat extends AbstractAnimal {
    private static String VOICE = "пипи";

    public Rat(String name) {
        this.setName(name);
    }

    @Override
    public void doSound() {
        System.out.println(this.getName() + " говорит: " + VOICE);
    }
}
