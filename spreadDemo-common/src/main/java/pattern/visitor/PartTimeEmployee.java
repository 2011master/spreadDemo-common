package pattern.visitor;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PartTimeEmployee implements Employee {

    private String name;
    private BigDecimal hourWage;
    private int workTime;

    public PartTimeEmployee(String name, BigDecimal hourWage, int workTime) {
        this.name = name;
        this.hourWage = hourWage;
        this.workTime = workTime;
    }

    @Override
    public void accept(Department department) {
        department.visit(this);
    }
}
