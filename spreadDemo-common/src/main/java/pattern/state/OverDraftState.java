package pattern.state;

import java.math.BigDecimal;

public class OverDraftState extends AccountState {


    public OverDraftState(AccountState accountState) {
        this.account = accountState.account;
    }

    @Override
    public void deposit(BigDecimal amount) {
        account.setBalance(account.getBalance().add(amount));
        stateCheck();
    }

    @Override
    public void withdraw(BigDecimal amount) {
        account.setBalance(account.getBalance().subtract(amount));
        stateCheck();
    }

    @Override
    public void computeInterest() {
        System.out.println("计算利息");
    }

    @Override
    public void stateCheck() {
        if (account.getBalance().compareTo(new BigDecimal(0)) >= 0) {
            account.setAccountState(new NormalState(this));
        } else if (account.getBalance().compareTo(new BigDecimal(-2000)) == 0) {
            account.setAccountState(new RestrictedState(this));
        } else if (account.getBalance().compareTo(new BigDecimal(-2000)) < 0) {
            System.out.println("操作受限！");
        }
    }
}
