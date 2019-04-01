package pattern.template;

import java.math.BigDecimal;

public class SaveAccount extends Account {
    @Override
    public BigDecimal caculate() {
        System.out.println("按死期计算利息");
        return null;
    }
}
