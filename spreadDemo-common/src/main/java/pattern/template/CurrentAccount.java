package pattern.template;

import java.math.BigDecimal;

public class CurrentAccount extends Account {
    @Override
    public BigDecimal caculate() {
        System.out.println("按活期计算利息");
        return null;
    }
}
