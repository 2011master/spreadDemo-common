package pattern.strategy;

import java.math.BigDecimal;

public class StudentDiscount implements Discount {

    @Override
    public BigDecimal caculate(BigDecimal price) {
        System.out.println("学生票");
        return price.multiply(new BigDecimal(0.8));
    }
}
