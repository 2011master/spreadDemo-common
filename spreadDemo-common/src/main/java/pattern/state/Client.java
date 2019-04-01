package pattern.state;

import java.math.BigDecimal;

public class Client {

    public static void main(String[] args) {
        Account account = new Account("段誉", new BigDecimal(0));
        account.deposit(new BigDecimal(1000));
        account.withdraw(new BigDecimal(2000));
        account.deposit(new BigDecimal(3000));
        account.withdraw(new BigDecimal(4000));
        account.withdraw(new BigDecimal(4000));
        account.computeInterest();
    }
}
