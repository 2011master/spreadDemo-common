package pattern.strategy;

import java.math.BigDecimal;

public class ChildrenDiscount implements Discount {

    @Override
    public BigDecimal caculate(BigDecimal price) {
        System.out.println("儿童票");
        return price.subtract(new BigDecimal(10));
    }
}
