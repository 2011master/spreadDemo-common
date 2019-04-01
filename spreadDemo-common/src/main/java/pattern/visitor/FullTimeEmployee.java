package pattern.visitor;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FullTimeEmployee implements Employee {

    private String name;
    private BigDecimal weeklyWage;
    private int workTime;

    public FullTimeEmployee(String name, BigDecimal weeklyWage, int workTime) {
        this.name = name;
        this.weeklyWage = weeklyWage;
        this.workTime = workTime;
    }

    @Override
    public void accept(Department department) {
        department.visit(this);
    }
}
