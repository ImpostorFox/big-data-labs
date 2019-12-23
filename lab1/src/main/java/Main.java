import xml.employees.Employee;
import xml.employees.Employees;
import xml.ioxml.IOXml;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static Employees employeesList = new Employees();


    public static void main(String[] args) {
        //Get main info of employees
        List<Employee> employees = IOXml.getEmployee("lab1.xml");
        //Set obfuscated objects
        employeesList.setEmployees(employees.stream().map(Employee::obfuscateObject).collect(Collectors.toList()));
        //Write to xml file
        IOXml.serializeToXMLEmployee("obfuscated.xml", employeesList, true);
        //----unobfuscate-----
        employees.clear();
        // read obfuscated file
        employees = IOXml.getEmployee("obfuscated.xml");
        //set unobfuscated objects
        employeesList.setEmployees(employees.stream().map(Employee::unobfuscateObject).collect(Collectors.toList()));
        //write result\
        IOXml.serializeToXMLEmployee("unobfuscated.xml", employeesList, false);
        System.out.println("Done");
    }
}
