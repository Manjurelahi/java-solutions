import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class Education {
    private String course;
    private float percentageMarks;

    public Education() {}

    public Education(String course, float percentageMarks) {
        this.course = course;
        this.percentageMarks = percentageMarks;
    }

    public String getCourse() {
        return course;
    }

    @XmlAttribute(name = "Course")
    public void setCourse(String course) {
        this.course = course;
    }

    public float getPercentageMarks() {
        return percentageMarks;
    }

    @XmlValue
    public void setPercentageMarks(float percentageMarks) {
        this.percentageMarks = percentageMarks;
    }
}

@XmlType(propOrder = {"employeeName", "educationList"})
class Employee {
    private int employeeID;
    private String employeeName;
    private List<Education> educationList;

    public int getEmployeeID() {
        return employeeID;
    }

    @XmlAttribute(name = "EmployeeID")
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    @XmlElement(name = "EmployeeName")
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    @XmlElement(name = "Education")
    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }
}

@XmlRootElement(name = "EmployeeEducation")
class EmployeeEducation {
    private List<Employee> employeeList = new ArrayList<Employee>();
    public List<Employee> getEmployeeList() {
        return employeeList;
    }
    @XmlElement(name = "Employee")
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}

public class XmlJAXB {
    public static void main(String[] args) throws JAXBException {
        List<Education> educationList = new ArrayList<>();
        educationList.add(new Education("B.E.(IT)", 71.57f));
        educationList.add(new Education("12th-HSC", 76.67f));
        educationList.add(new Education("10th-SSC", 81.86f));

        Employee employee = new Employee();
        employee.setEmployeeName("Manjur");
        employee.setEmployeeID(786);
        employee.setEducationList(educationList);

        List <Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);

        EmployeeEducation employeeEducation = new EmployeeEducation();
        employeeEducation.setEmployeeList(employeeList);

        JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeEducation.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        File xmlFile = new File("EmployeeEducation.xml");
        System.out.println("-----JAXB Marshalling-----");
        marshaller.marshal(employeeEducation, xmlFile);
        marshaller.marshal(employeeEducation, System.out);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        EmployeeEducation unmarshalledEmpEdu = (EmployeeEducation)unmarshaller.unmarshal(xmlFile);
        System.out.println("\n-----JAXB Unmarshalling-----");
        unmarshalledEmpEdu.getEmployeeList().forEach(emp -> {
            System.out.println("Employee ID = "+emp.getEmployeeID()+" Name = "+emp.getEmployeeName());
			System.out.println("Education:");
            emp.getEducationList().forEach(edu ->
                    System.out.println("Course = " + edu.getCourse() + " Percentage Marks = " + edu.getPercentageMarks() + "%"));
        });
    }
}

/*
Output:
-----JAXB Marshalling-----
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<EmployeeEducation>
    <Employee EmployeeID="786">
        <EmployeeName>Manjur</EmployeeName>
        <Education Course="B.E.(IT)">71.57</Education>
        <Education Course="12th-HSC">76.67</Education>
        <Education Course="10th-SSC">81.86</Education>
    </Employee>
</EmployeeEducation>

-----JAXB Unmarshalling-----
Employee ID = 786 Name = Manjur
Education:
Course = B.E.(IT) Percentage Marks = 71.57%
Course = 12th-HSC Percentage Marks = 76.67%
Course = 10th-SSC Percentage Marks = 81.86%
 */