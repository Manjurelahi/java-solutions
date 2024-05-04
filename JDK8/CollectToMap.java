/*
Suppose Employee object has only two attributes as Name and Salary.
Write a Java program by using Stream API to convert a list of such Employee into a Map by considering key as Employee object and value as Salary.
Then sort that map based on Salary such as highest salaried Employee should be first key entry in map
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private Integer salary;

    public Employee(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
public class CollectToMap {
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee("Ajay", 5000),
                new Employee("Vijay", 50),
                new Employee("Elahi", 500),
                new Employee("Manjur", 555)
                );

        employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toMap(Function.identity(), Employee::getSalary, (obj1, obj2) -> obj2, LinkedHashMap::new))
                .keySet().iterator().forEachRemaining(System.out::println);
    }
}

/*
Output:
Employee{name='Ajay', salary=5000}
Employee{name='Manjur', salary=555}
Employee{name='Elahi', salary=500}
Employee{name='Vijay', salary=50}
 */
