package lesson20;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lesson20.dto.Employee;
import lesson20.dto.EmployeeWrapper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class JSONRunner {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = JSONRunner.class.getResourceAsStream("/employee.xml");
        String text = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        List<Employee> employees = getEmployees(text);
        boolean show = false;
        for (int i = 0; i < employees.size(); i++) {
            if (show) { // i%2 != 0
                System.out.println(employees.get(i));
            }
            show = !show;
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(employees);
        FileWriter fw = new FileWriter("src/main/resources/employee.json");
        fw.write(json);
        fw.flush();
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
}
