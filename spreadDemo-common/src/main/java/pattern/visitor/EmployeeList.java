package pattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {

    private List<Employee> employees = new ArrayList<>();


    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void accept(Department department) {

        employees.forEach(item ->{
            item.accept(department);
        });

    }
}
