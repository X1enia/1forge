package lesson20.dto;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lesson20.dto.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@XmlRootElement(name="employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeWrapper {

    @XmlElement(name="employee")
    private List<Employee> employeeList;
}
