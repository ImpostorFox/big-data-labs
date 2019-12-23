package xml.employees;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
    @XmlAttribute(name = "id")
    @XmlID
    private String id;
    @XmlElement
    private String name;
    @XmlElement
    private String lastName;
    @XmlElement
    private String location;

    public Employee(String id, String name, String lastName, String location) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.location = location;
    }

    public Employee() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @JsonIgnore
    private static final String key = "Zx" + Math.log(2) / 3;
    @JsonIgnore
    static String source="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    @JsonIgnore
    static String target="Q5A8ZWS0XEDC6RFVT9GBY4HNU3J2MI1KO7LP";

    public  String obfuscateString(String s) {
        char[] result= new char[s.length()];
        for (int i=0;i<s.length();i++) {
            char c=s.toUpperCase().charAt(i);
            int index=source.indexOf(c);
            result[i]=target.charAt(index);
        }

        return new String(result);
    }

    public  String unobfuscateString(String s) {
        char[] result= new char[s.length()];
        for (int i=0;i<s.length();i++) {
            char c=s.toUpperCase().charAt(i);
            int index=target.indexOf(c);
            result[i]=source.charAt(index);
        }

        return StringUtils.capitalize(new String(result).toLowerCase());
    }

    public Employee obfuscateObject() {
        setId(obfuscateString(getId()));
        setName(obfuscateString(getName()));
        setLastName(obfuscateString(getLastName()));
        setLocation(obfuscateString(getLocation()));
        return this;
    }
    public Employee unobfuscateObject() {
        setId(unobfuscateString(getId()));
        setName(unobfuscateString(getName()));
        setLastName(unobfuscateString(getLastName()));
        setLocation(unobfuscateString(getLocation()));
        return this;
    }
}
