package lesson13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Никита Федорович Смирнов", 123, 5));
        employees.add(new Employee("Анастасия Владимировна Иванова", 315, 8));
        employees.add(new Employee("Артем Борисович Барсуков", 721, 15));
        employees.add(new Employee("Денис Сергеевич Печенько", 982, 8));

        filterEmployeeByWorkAge(employees, 8);
        removeEmployee(employees);
    }

    public static void filterEmployeeByWorkAge(List<Employee> employees, int workAge) {
        Iterator<Employee> employeeIterator = employees.iterator();
        while (employeeIterator.hasNext()) {
            Employee employee = employeeIterator.next();
            if (employee.getWorkAge() == workAge) {
                System.out.println(employee.getName() + " " + employee.getNumber() + " " + employee.getWorkAge());
            }
        }
    }

    public static void removeEmployee(List<Employee> employees) {
        Stack<Employee> employeeStack = new Stack<>();
        for (Employee employee : employees) {
            employeeStack.add(employee);
        }
        final int stackSize = employeeStack.size();

        for (int i = 1; i < stackSize; i++) {
            if (i % 2 != 0) {
                employees.remove(employeeStack.pop());
            } else {
                employeeStack.pop();
            }
        }
    }
}
