package pattern.strategy;

import java.math.BigDecimal;

public interface Discount {

    BigDecimal caculate(BigDecimal price);
}
