package pattern.strategy;

import java.math.BigDecimal;

public class VipDiscount implements Discount {

    @Override
    public BigDecimal caculate(BigDecimal price) {
        System.out.println("VIP票");
        System.out.println("增加积分");
        return price.multiply(new BigDecimal(0.5));
    }
}
