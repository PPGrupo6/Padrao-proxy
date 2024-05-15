package ProxyPattern;

import java.util.List;

public class EmployeeProxy implements IEmployee {

    private Employee employee;

    private Integer id;

        public EmployeeProxy(Integer id) {
        this.id = id;
    }

    @Override
    public List<String> getPersonalData() {
        if (this.employee == null) {
            this.employee = new Employee(this.id);
        }
        return this.employee.getPersonalData();
    }

    @Override
    public List<Float> getSalary(Boss boss) {
        if (!boss.isAdmin()) {
            throw new IllegalArgumentException("Funcionário não autorizado");
        }
        if (this.employee == null) {
            this.employee = new Employee(this.id);
        }
        return this.employee.getSalary(boss);
    }
}
