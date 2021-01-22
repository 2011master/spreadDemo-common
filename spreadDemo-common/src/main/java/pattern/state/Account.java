package pattern.state;

import java.math.BigDecimal;

public class Account {

    private BigDecimal balance = BigDecimal.ZERO;
    private AccountState accountState;
    private String accountName;

    public Account( String accountName,BigDecimal init) {
        this.accountName = accountName;
        this.balance = init;
        this.accountState = new NormalState(this);
        System.out.println(this.accountName+"开户,初始金额为："+init);
        System.out.println("-------------------");
    }

    public void setAccountState(AccountState accountState) {
        this.accountState = accountState;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void deposit(BigDecimal amount) {
        System.out.println(this.accountName+"存款"+ amount);
        accountState.deposit(amount);
        display();
    }

    public void withdraw(BigDecimal amount) {
        System.out.println(this.accountName+"取款"+ amount);
        accountState.withdraw(amount);
        display();
    }

    public void computeInterest() {
        System.out.println(this.accountName+"计算利息");
        accountState.computeInterest();
        display();
    }

    public void display() {
        System.out.println(this.accountName+"当前余额为"+this.getBalance());
        System.out.println(this.accountName+"当前状态为"+this.accountState.getClass().getName());
        System.out.println("---------------");
    }


}
