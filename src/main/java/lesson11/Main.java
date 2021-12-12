package lesson11;

import lesson11.exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Automobile> automobileList = genAuto();
        for (int i = 0; i < automobileList.size(); i++) {
            try {
                ControlPoint.checkAuto(automobileList.get(i));
            } catch (NegativeValueException | SpeedException | WeighException | HeightException | WidthException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Automobile> genAuto() {
        Car car = new Car(1, 20.0, 3.5, 2, 1.5, 2.0, AutoType.CAR);
        Car car1 = new Car(2, 40.0, 3.0, 2.3, 1.2, 2.3, AutoType.CAR);
        Car car2 = new Car(3, 45.5, 2.5, 1.5, 2, 2.5, AutoType.CAR);
        Car car3 = new Car(4, 80.0, 4.0, 2.0, 2.5, 2.0, AutoType.CAR);
        Car car4 = new Car(5, 85.0, 2, 1.9, 9, 3.0, AutoType.CAR);
        Car car5 = new Car(6, 110, 1.5, 1.5, 1.5, 2, AutoType.CAR);
        Car car6 = new Car(7, 55, 2.0, 2, 2.7, 2.5, AutoType.CAR);
        Car car7 = new Car(8, 82, 9.0, 2.0, 1.0, 1.5, AutoType.CAR);
        Car car8 = new Car(9, 36, 5.0, 4.0, 1.8, 2.3, AutoType.CAR);
        Car car9 = new Car(10, 30, 3.0, 2.4, 2.2, 2.0, AutoType.CAR);

        Truck truck = new Truck(1, 87.0, 7.0, 4.0, 2.3, 5.0, AutoType.TRUCK);
        Truck truck1 = new Truck(2, 40.0, 8.0, 3.9, 1.9, 4.0, AutoType.TRUCK);
        Truck truck2 = new Truck(3, 53.0, 3.7, 24.5, 2.4, 3.5, AutoType.TRUCK);
        Truck truck3 = new Truck(4, 70.0, 2.0, 3.0, 2.8, 3.0, AutoType.TRUCK);
        Truck truck4 = new Truck(5, 20.0, 6.0, 2.9, 2.1, 2.0, AutoType.TRUCK);
        Truck truck5 = new Truck(6, 25.1, 7.8, 3.5, 2.2, 1.7, AutoType.TRUCK);
        Truck truck6 = new Truck(7, 50.0, 5.0, 2.4, 1.8, 1.5, AutoType.TRUCK);
        Truck truck7 = new Truck(8, 78.0, 4.0, 4.9, 2.5, 2.0, AutoType.TRUCK);
        Truck truck8 = new Truck(9, 30.0, 1.5, 3.0, 2.0, 5.0, AutoType.TRUCK);
        Truck truck9 = new Truck(10, 49.6, 5.9, 2.0, 2.0, 7.0, AutoType.TRUCK);
        List<Automobile> automobileList = new ArrayList<>();
        automobileList.add(car);
        automobileList.add(car1);
        automobileList.add(car2);
        automobileList.add(car3);
        automobileList.add(car4);
        automobileList.add(car5);
        automobileList.add(car6);
        automobileList.add(car7);
        automobileList.add(car8);
        automobileList.add(car9);
        automobileList.add(truck);
        automobileList.add(truck1);
        automobileList.add(truck2);
        automobileList.add(truck3);
        automobileList.add(truck4);
        automobileList.add(truck5);
        automobileList.add(truck6);
        automobileList.add(truck7);
        automobileList.add(truck8);
        automobileList.add(truck9);

        return automobileList;
    }
}
