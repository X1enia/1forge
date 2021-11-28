package lesson8;

public class Rat extends AbstractAnimal {
    private String voice;

    public Rat(String name, String voice) {
        this.setName(name);
        this.voice = voice;
    }

    @Override
    public void doSound() {
        System.out.println(this.getName() + " говорит: " + this.voice);
    }
}
