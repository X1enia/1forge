package lesson8;

public class Tiger extends AbstractAnimal {
    private static String VOICE = "ррр";

    public Tiger(String name) {
        this.setName(name);
    }

    @Override
    public void doSound() {
        System.out.println(this.getName() + " говорит: " + VOICE);
    }
}
