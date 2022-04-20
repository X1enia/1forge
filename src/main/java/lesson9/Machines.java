package lesson9;

public class Machines {
    public static void main (String [] args) {
        Car car = new Car("Kia");
        Car car1 = new Car("Dodge");
        Car car2 = new Car("Subaru");
        Car car3 = new Car("Audi");
        Car car4 = new Car("Lada");

        Truck truck = new Truck("ГАЗ");
        Truck truck1 = new Truck("ЗИЛ");
        Truck truck2 = new Truck("МАЗ");
        Truck truck3 = new Truck("БелАЗ");
        Truck truck4 = new Truck("КамАЗ");

        Automobile[] automobiles = new Automobile[] {car,car1,car2,car3,car4,truck,truck1,truck2,truck3,truck4};

        for (int i = 0; i < automobiles.length; i++) {
            double random = Math.random() * 1000;
            automobiles[i].doDrive((int)random);
        }
    }
}
