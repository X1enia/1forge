package lesson20;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lesson20.dto.Department;
import lesson20.dto.Employee;
import lesson20.dto.EmployeeWrapper;
import lesson20.dto.Employment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

public class JAXBRunner {

    public static void main(String[] args) throws Exception {
        Employee employee = new Employee();
        employee.setName("Петр");
        employee.setNumber("1325346");
        employee.setLogin("peter");

        Department department = new Department();
        department.setCity("Москва");
        department.setSubdivision("1");
        employee.setDepartment(department);

        Employment employment = new Employment();
        employment.setOccupation("Junior разработчик");
        employment.setSalary(30000);
        employee.setEmployment(employment);

        Employee employee1 = new Employee();
        employee1.setName("Антонина");
        employee1.setNumber("734648");
        employee1.setLogin("tonya22");

        Department department1 = new Department();
        department1.setCity("Хабаровск");
        department1.setSubdivision("182");
        employee1.setDepartment(department1);

        Employment employment1 = new Employment();
        employment1.setOccupation("Middle разработчик");
        employment1.setSalary(100000);
        employee1.setEmployment(employment1);

        Employee employee2 = new Employee();
        employee2.setName("Виталий");
        employee2.setNumber("73645");
        employee2.setLogin("vita");

        Department department2 = new Department();
        department2.setCity("Екатеринбург");
        department2.setSubdivision("854748");
        employee2.setDepartment(department2);

        Employment employment2 = new Employment();
        employment2.setOccupation("Lead разработчик");
        employment2.setSalary(200000);
        employee2.setEmployment(employment2);

        Employee employee3 = new Employee();
        employee3.setName("Татьяна");
        employee3.setNumber("3456");
        employee3.setLogin("tatyana");

        Department department3 = new Department();
        department3.setCity("Владикавказ");
        department3.setSubdivision("943857");
        employee3.setDepartment(department3);

        Employment employment3 = new Employment();
        employment3.setOccupation("Junior разработчик");
        employment3.setSalary(45000);
        employee3.setEmployment(employment3);

        Employee employee4 = new Employee();
        employee4.setName("Валерий");
        employee4.setNumber("34756");
        employee4.setLogin("valera");

        Department department4 = new Department();
        department4.setCity("Сызрань");
        department4.setSubdivision("45633");
        employee4.setDepartment(department4);

        Employment employment4 = new Employment();
        employment4.setOccupation("Lead разработчик");
        employment4.setSalary(120000);
        employee4.setEmployment(employment4);

        Employee employee5 = new Employee();
        employee5.setName("Ефросинья");
        employee5.setNumber("435645");
        employee5.setLogin("frosya");

        Department department5 = new Department();
        department5.setCity("Санкт-Петербург");
        department5.setSubdivision("34678");
        employee5.setDepartment(department5);

        Employment employment5 = new Employment();
        employment5.setOccupation("Middle разработчик");
        employment5.setSalary(80000);
        employee5.setEmployment(employment5);

        Employee employee6 = new Employee();
        employee6.setName("Агафон");
        employee6.setNumber("390574");
        employee6.setLogin("Agaphone");

        Department department6 = new Department();
        department6.setCity("Тверь");
        department6.setSubdivision("992364");
        employee6.setDepartment(department6);

        Employment employment6 = new Employment();
        employment6.setOccupation("Junior разработчик");
        employment6.setSalary(35000);
        employee6.setEmployment(employment6);

        Employee employee7 = new Employee();
        employee7.setName("Кристина");
        employee7.setNumber("348565");
        employee7.setLogin("Kristy");

        Department department7 = new Department();
        department7.setCity("Новосибирск");
        department7.setSubdivision("943123");
        employee7.setDepartment(department7);

        Employment employment7 = new Employment();
        employment7.setOccupation("Lead разработчик");
        employment7.setSalary(135000);
        employee7.setEmployment(employment7);

        Employee employee8 = new Employee();
        employee8.setName("Антон");
        employee8.setNumber("87542");
        employee8.setLogin("anton");

        Department department8 = new Department();
        department8.setCity("Мурманск");
        department8.setSubdivision("3847542");
        employee8.setDepartment(department8);

        Employment employment8 = new Employment();
        employment8.setOccupation("Junior разработчик");
        employment8.setSalary(20000);
        employee8.setEmployment(employment8);

        Employee employee9 = new Employee();
        employee9.setName("Апполинария");
        employee9.setNumber("3056");
        employee9.setLogin("polina");

        Department department9 = new Department();
        department9.setCity("Гатчина");
        department9.setSubdivision("9431877");
        employee9.setDepartment(department9);

        Employment employment9 = new Employment();
        employment9.setOccupation("Middle разработчик");
        employment9.setSalary(78000);
        employee9.setEmployment(employment9);

        EmployeeWrapper wrapper = new EmployeeWrapper();
        wrapper.setEmployeeList(List.of(employee, employee1, employee2, employee3, employee4, employee5, employee6, employee7,
                employee8, employee9));
        generateXML(wrapper);

    }

    private static Employee getEmployee(String xmlContent) {
        try {
            JAXBContext context = JAXBContext.newInstance(Employee.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader sr = new StringReader(xmlContent);
            return (Employee) unmarshaller.unmarshal(sr);
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<Employee> getEmployees(String xmlContent) {
        try {
            JAXBContext context = JAXBContext.newInstance(EmployeeWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader sr = new StringReader(xmlContent);
            EmployeeWrapper ew = (EmployeeWrapper) unmarshaller.unmarshal(sr);
            if (ew != null) {
                return ew.getEmployeeList();
            } else {
                return null;
            }
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void generateXML(Employee employee) {
        try {
            JAXBContext context = JAXBContext.newInstance(Employee.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            marshaller.marshal(employee, sw);
            System.out.println("XML: \n" + sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void generateXML(EmployeeWrapper wrapper) {
        try {
            JAXBContext context = JAXBContext.newInstance(EmployeeWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            marshaller.marshal(wrapper, new FileOutputStream("src/main/resources/employee.xml"));
            System.out.println("XML created" + sw);
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

