package lesson9;

public abstract class Automobile {
    private String name;

    public Automobile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public abstract void doDrive(int distance);
}
