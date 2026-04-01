// Sort Employee with name first then salary

import java.util.Comparator;
import java.util.List;

class Employee {
    int id;
    String name;
    int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class StreamSortThenComparing {
    public static void main(String[] args) {
        List<Employee> employeeList = new java.util.ArrayList<>(List.of(
                new Employee(1, "Akshay", 3000),
                new Employee(2, "Ajay", 8500),
                new Employee(3, "Akshay", 5500)
        ));

        // By JDK 8 Stream API Sorted Method
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary).reversed())
                .forEach(System.out::println);

        // By Array List Sort Method
        employeeList.sort(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary).reversed());
        employeeList.forEach(System.out::println);
    }
}

/*
Output:
Employee{id=3, name='Akshay', salary=5500}
Employee{id=1, name='Akshay', salary=3000}
Employee{id=2, name='Ajay', salary=8500}
 */