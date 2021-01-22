package pattern.state;

import java.math.BigDecimal;

public abstract class AccountState {

    protected Account account;

    public abstract void deposit(BigDecimal amount);

    public abstract void withdraw(BigDecimal amount);

    public abstract void computeInterest();

    public abstract void stateCheck();

}
