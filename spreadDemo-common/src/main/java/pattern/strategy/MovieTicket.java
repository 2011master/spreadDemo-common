package pattern.strategy;

import java.math.BigDecimal;

public class MovieTicket {

    private BigDecimal price;
    private Discount discount;

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {

        return price;
    }

    public BigDecimal getDiscountPrice() {
        return discount.caculate(price);
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
