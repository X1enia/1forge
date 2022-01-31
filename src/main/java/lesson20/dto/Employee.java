package lesson20.dto;

import jakarta.xml.bind.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors (chain = true)
@XmlType(propOrder = {"name", "number", "login", "department", "employment"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Employee {

    @XmlAttribute(name = "n")
    private String name;

    @XmlAttribute(name = "num")
    private String number;

    @XmlAttribute(name = "l")
    private String login;

    @XmlElement(name = "d")
    private Department department;

    private Employment employment;


}
