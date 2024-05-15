package ProxyPattern;

import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<Integer, Employee> employees = new HashMap<>();

    public static Employee getEmployee(Integer matricula) {
        return employees.get(matricula);
    }

    public static void addEmployee(Employee employee) {
        employees.put(employee.getId(), employee);
    }
}
