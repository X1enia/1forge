package lesson9;

public final class Car extends Automobile {

    private static final int MOVE_DISTANCE = 500;

    public Car(String name) {
        super(name);
    }

    @Override
    public void doDrive(int distance) {
        if (distance < 0) {
            System.out.println("Дистанция не может быть меньше нуля.");
        } else if (distance  > MOVE_DISTANCE) {
            System.out.println(this.getName() + " не может проехать больше " + MOVE_DISTANCE + " километров.");
        } else {
            System.out.println(this.getName() + " проедет " + distance);
        }
    }
}
