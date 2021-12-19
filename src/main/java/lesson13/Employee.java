package lesson13;

public class Employee {
    private String name;
    private Integer number;
    private Integer workAge;

    public Employee(String name, Integer number, Integer workAge) {
        this.name = name;
        this.number = number;
        this.workAge = workAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getWorkAge() {
        return workAge;
    }

    public void setWorkAge(Integer workAge) {
        this.workAge = workAge;
    }
}
