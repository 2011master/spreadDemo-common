package pattern.state;

import java.math.BigDecimal;

public class RestrictedState extends AccountState {


    public RestrictedState(AccountState accountState) {
        this.account = accountState.account;
    }

    @Override
    public void deposit(BigDecimal amount) {
        account.setBalance(account.getBalance().add(amount));
        stateCheck();
    }

    @Override
    public void withdraw(BigDecimal amount) {
        System.out.println("操作受限，取款失败");
    }

    @Override
    public void computeInterest() {
        System.out.println("计算利息");
    }

    @Override
    public void stateCheck() {
        if (account.getBalance().compareTo(new BigDecimal(0)) >= 0) {
            account.setAccountState(new NormalState(this));
        } else if (account.getBalance().compareTo(new BigDecimal(-2000)) > 0 &&
                account.getBalance().compareTo(new BigDecimal(0)) <= 0
        ) {
            account.setAccountState(new OverDraftState(this) );
        } else if (account.getBalance().compareTo(new BigDecimal(-2000)) < 0) {
            System.out.println("操作受限！");
        }
    }
}
