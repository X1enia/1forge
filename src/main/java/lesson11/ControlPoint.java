package lesson11;

import lesson11.exceptions.*;

public class ControlPoint {
    public static void checkAuto(Automobile auto) throws WeighException, NegativeValueException, SpeedException, HeightException, WidthException {
        double weigh = auto.getWeigh();
        if (weigh > 8) {
            throw new WeighException("Вес автомобиля " + auto.getAutoType() + " " + auto.getNumber() + " превышает 8.");
        } else if (weigh < 0) {
            throw new NegativeValueException("Вес автомобиля не может быть меньше нуля.");
        }
        double speed = auto.getSpeed();
        if (speed > 100) {
            throw new SpeedException("Скорость автомобиля " + auto.getAutoType() + " " + auto.getNumber() + " превышает 100. Полиция ловит преступника.");
        } else if (speed > 80) {
            throw new SpeedException("Скорость автомобиля " + auto.getAutoType() + " " + auto.getNumber() + " превышает 80.");
        } else if (speed < 0) {
            throw new NegativeValueException("Скорость автомобиля не может быть меньше нуля.");
        }
        double height = auto.getHeight();
        if (height > 4) {
            throw new HeightException("Высота автомобиля " + auto.getAutoType() + " " + auto.getNumber() + " превышает 4");
        } else if (height < 0) {
            throw new NegativeValueException("Высота автомобиля не может быть меньше нуля.");
        }
        double width = auto.getWidth();
        if (width > 2.5) {
            throw new WidthException("Ширина автомобиля " + auto.getAutoType() + " " + auto.getNumber() + " превышает 2.5");
        } else if (width < 0) {
            throw new NegativeValueException("Ширина автомобиля не может быть меньше нуля.");
        }

        System.out.println(auto.getAutoType()+ " " + auto.getNumber() + " свободно проезжает.");
    }
}
