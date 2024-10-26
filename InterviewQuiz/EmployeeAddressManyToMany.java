/*
Consider below two Entity Lists.
1. Employee [EmployeeID, EmployeeName]
2. Address City [PinZipID, CityName, EmployeeID]
Above entities have association as Bi-directional Many-To-Many relationship.
Write a Java program based on above details to find Employee and List of Employee Address City,
with minimum time complexity or by using single or minimum loop.
 */

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    private int employeeID;
    private String employeeName;

    public Employee(int employeeID, String employeeName) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }
}

class AddressCity {
    private int pinZipID;
    private String cityName;
    private int employeeID;

    public AddressCity(int pinZipID, String cityName, int employeeID) {
        this.pinZipID = pinZipID;
        this.cityName = cityName;
        this.employeeID = employeeID;
    }

    public int getPinZipID() {
        return pinZipID;
    }

    public String getCityName() {
        return cityName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public Employee getEmployee(int employeeID, List<Employee> list) {
        for (Employee employee: list) {
           if (employeeID == employee.getEmployeeID()) {
               return employee;
           }
        }
        return null;
    }

    @Override
    public String toString() {
        return "cityName='" + cityName + '\'';
    }
}

public class EmployeeAddressManyToMany {

    public static void main(String args[]) {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "Ramesh"),
                new Employee(2, "Mahesh"),
                new Employee(3, "Nisha"),
                new Employee(4, "Bhaskar")
        );

        List<AddressCity> addressList = Arrays.asList(
                new AddressCity(400001, "Mumbai", 2),
                new AddressCity(400002, "Delhi", 1),
                new AddressCity(400003, "Kolkata", 2),
                new AddressCity(400004, "Chennai", 3),
                new AddressCity(400005, "Pune", 2),
                new AddressCity(400006, "Surat", 1)
        );        

        Map<Employee, List<AddressCity>> employeeAddressMap = addressList.stream().collect(Collectors.groupingBy(address -> address.getEmployee(address.getEmployeeID(), employeeList)));
        employeeAddressMap.entrySet().forEach(System.out::println);

    }
}