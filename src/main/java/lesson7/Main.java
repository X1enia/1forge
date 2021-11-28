package lesson7;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("Барсик");
        cat.doRun(50);
        cat.doSwim(100500);

        Dog dog = new Dog();
        dog.setName("Бобик");
        dog.doRun(500);
        dog.doSwim(10);

        Tiger tiger = new Tiger();
        tiger.setName("Шерхан");
        tiger.doRun(1000);
        tiger.doSwim(20);

        Rat rat = new Rat();
        rat.setName("Рататуй");
        rat.doRun(15);
        rat.doSwim(5);

        Gazelle gazelle = new Gazelle();
        gazelle.setName("Газель");
        gazelle.doRun(2000);
        gazelle.doSwim(3);
    }
}
