package lesson8;

public class Cat extends AbstractAnimal {
    private String voice;

    public Cat(String name, String voice) {
        this.setName(name);
        this.voice = voice;
    }

    @Override
    public void doSound() {
        System.out.println(this.getName() + " говорит: " + this.voice);
    }
}
