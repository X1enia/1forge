package lesson8;

public class Cat extends AbstractAnimal {
    private static String VOICE = "мяу";

    public Cat(String name) {
        this.setName(name);
    }

    @Override
    public void doSound() {
        System.out.println(this.getName() + " говорит: " + VOICE);
    }
}
