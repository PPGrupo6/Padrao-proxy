package ProxyPattern;

import java.util.Arrays;
import java.util.List;

public class Employee implements IEmployee {

    private Integer id;
    private String name;
    private String city;
    private Float salary;

    public Employee(int id) {
        this.id = id;
        Employee objeto = BD.getEmployee(id);
        this.name = objeto.name;
        this.city = objeto.city;
        this.salary = objeto.salary;
    }

    public Employee(Integer id, String name, String city, Float salary) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public List<String> getPersonalData() {
        return Arrays.asList(this.name, this.city);
    }

    @Override
    public List<Float> getSalary(Boss boss) {
        return Arrays.asList(this.salary);
    }
}
