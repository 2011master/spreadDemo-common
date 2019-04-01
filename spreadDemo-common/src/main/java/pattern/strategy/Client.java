package pattern.strategy;

import java.math.BigDecimal;

public class Client {

    public static void main(String[] args) {
        MovieTicket movieTicket = new MovieTicket();
        movieTicket.setPrice(new BigDecimal(60));

        System.out.println("原价为:"+movieTicket.getPrice());

        Discount discount = new StudentDiscount();
        movieTicket.setDiscount(discount);
        BigDecimal price = movieTicket.getDiscountPrice();
        System.out.println("当前价格为："+price);
    }
}
