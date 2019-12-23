package xml.ioxml;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import xml.employees.Employee;
import xml.employees.Employees;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class IOXml {
    private static XmlMapper xmlMapper = new XmlMapper();

    public static void serializeToXMLEmployee(String name, Employees employees, boolean isObfuscate) {
        File xmlOutput = new File(name);
        xmlMapper.registerModule(new JaxbAnnotationModule());
        if (!isObfuscate) {
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        }
        try (FileWriter fileWriter = new FileWriter(xmlOutput);) {
            String xmlString = xmlMapper.writeValueAsString(employees);
            fileWriter.write(xmlString);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static String deserializeFromXML(String name) {
        try {
            return new String(Files.readAllBytes(Paths.get(name)));
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }

    public static List<Employee> getEmployee(String name) {
        try {
            return xmlMapper.readValue(deserializeFromXML(name), new TypeReference<List<Employee>>() {});
        } catch (Exception e) {
            System.out.println(e);
        }
        return Collections.emptyList();
    }


}
