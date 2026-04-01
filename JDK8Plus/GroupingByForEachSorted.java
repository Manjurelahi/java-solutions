// Department wise highest salaried employee

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    int salary;
    String department;

    public Employee(int id, String name, int salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}

public class GroupingByForEachSorted {
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
        new Employee(1, "Vijay", 5000, "Accounts"),
        new Employee(2, "Ajay", 2500, "Accounts"),
        new Employee(3, "Dhara", 8150, "Accounts"),
        new Employee(4, "Manjur", 9000, "Engineering"),
        new Employee(5, "Elahi",8990 , "Engineering"),
        new Employee(6, "Mahesh", 7025, "Engineering"),
        new Employee(7, "Arun", 8025, "HR"),
        new Employee(8, "Sheetal", 8800, "HR"),
        new Employee(9, "Tina", 8750, "HR")
        );
        Map<String, List<Employee>> deptEmployeesMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        Map<String, Employee> deptHighestSalariedEmpMap = new HashMap<>();
        deptEmployeesMap.forEach((key, value) -> deptHighestSalariedEmpMap.put(
                key,
                value.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).toList().getFirst()
        ));
        deptHighestSalariedEmpMap.forEach((s, employee) -> {
            System.out.println("Department: "+s);
            System.out.println("Highest Salaried Employee\n"+employee.toString()+"\n");
        });
    }
}

/*
Output:
Department: Engineering
Highest Salaried Employee
Employee{id=4, name='Manjur', salary=9000, department='Engineering'}

Department: HR
Highest Salaried Employee
Employee{id=8, name='Sheetal', salary=8800, department='HR'}

Department: Accounts
Highest Salaried Employee
Employee{id=3, name='Dhara', salary=8150, department='Accounts'}
*/