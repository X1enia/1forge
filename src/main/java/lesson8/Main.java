package lesson8;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Барсик", "мяу");
        Dog dog = new Dog("Бобик", "гав");
        Rat rat = new Rat("Рататуй", "пипи");
        Tiger tiger = new Tiger("Шерхан", "ррр");

        AbstractAnimal[] animals = new AbstractAnimal[]{cat, dog, rat, tiger};

        for (int i = 0; i < animals.length; i++) {
            animals[i].doSound();
        }
    }
}
