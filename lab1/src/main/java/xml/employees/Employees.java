package xml.employees;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "employees")
public class Employees implements Serializable {
    private static final long serialVersionUID = 22L;

    @JacksonXmlProperty(localName = "employee")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Employee> employees = new ArrayList<>();

    public Employees() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
