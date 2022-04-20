package lesson8;

public class AbstractZoo {
    public static void main(String[] args) {
        Cat cat = new Cat("Барсик");
        Dog dog = new Dog("Бобик");
        Rat rat = new Rat("Рататуй");
        Tiger tiger = new Tiger("Шерхан");

        AbstractAnimal[] animals = new AbstractAnimal[]{cat, dog, rat, tiger};

        for (int i = 0; i < animals.length; i++) {
            animals[i].doSound();
        }
    }
}
