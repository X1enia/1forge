package lesson8;

public class Dog extends AbstractAnimal {
    private String voice;

    public Dog(String name, String voice) {
        this.setName(name);
        this.voice = voice;
    }

    @Override
    public void doSound() {
        System.out.println(this.getName() + " говорит: " + this.voice);
    }
}
