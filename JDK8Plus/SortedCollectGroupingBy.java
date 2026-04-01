/*
Write a function that takes a list of employees and returns a map where the keys are departments,
and the values are lists of employees sorted by their age in descending order.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private Integer age;
    private Integer salary;
    private String department;

    public Employee(String name, int age, int salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && salary == employee.salary
                && Objects.equals(name, employee.name)
                && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary, department);
    }

    @Override
    public String toString(){
        return "Name: "+this.getName() + " Age: "+this.getAge();
    }
}

public class SortedCollectGroupingBy {

    public static Map<String, List<Employee>> getDeptEmpList(List<Employee> empList) {
        return empList.stream()
                .sorted(Comparator.comparing(Employee::getAge).reversed())
                .collect(Collectors.groupingBy(employee -> employee.getDepartment()));
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 28, 60000, "HR"),
                new Employee("Bob", 35, 75000, "Engineering"),
                new Employee("Charlie", 32, 90000, "Engineering"),
                new Employee("David", 40, 80000, "HR"),
                new Employee("Eva", 28, 70000, "Finance"),
                new Employee("Frank", 45, 95000, "Finance")
        );
        getDeptEmpList(employees).forEach((s, empList) -> {
            System.out.println(s);
            empList.stream().forEach(System.out::println);
        });
    }
}

/*
Output:
Engineering
Name: Bob Age: 35
Name: Charlie Age: 32
Finance
Name: Frank Age: 45
Name: Eva Age: 28
HR
Name: David Age: 40
Name: Alice Age: 28
 */