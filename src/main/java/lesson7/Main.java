package lesson7;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.name = "Барсик";
        cat.run = 200;
        cat.swim = 0;

        cat.setRun();
        cat.setSwim();

        Dog dog = new Dog();
        dog.name = "Бобик";
        dog.run = 500;
        dog.swim = 10;

        dog.setRun();
        dog.setSwim();

        Tiger tiger = new Tiger();
        tiger.name = "Шерхан";
        tiger.run = 1000;
        tiger.swim = 20;

        tiger.setRun();
        tiger.setSwim();

        Rat rat = new Rat();
        rat.name = "Рататуй";
        rat.run = 15;
        rat.swim = 5;

        rat.setRun();
        rat.setSwim();

        Gazelle gazelle = new Gazelle();
        gazelle.name = "Газель";
        gazelle.run = 2000;
        gazelle.swim = 3;

        gazelle.setRun();
        gazelle.setSwim();
    }
}
