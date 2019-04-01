package pattern.state;

import java.math.BigDecimal;

public class NormalState extends AccountState {

    public NormalState(Account account) {
        this.account = account;
    }

    public NormalState(AccountState accountState) {
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
        System.out.println("正常状态无需支付利息");
    }

    @Override
    public void stateCheck() {
        if (account.getBalance().compareTo(new BigDecimal(-2000)) > 0 &&
                account.getBalance().compareTo(new BigDecimal(0)) <= 0
        ) {
            account.setAccountState(new OverDraftState(this));
        } else if (account.getBalance().compareTo(new BigDecimal(-2000)) == 0) {
            account.setAccountState(new RestrictedState(this));
        } else if (account.getBalance().compareTo(new BigDecimal(-2000)) < 0) {
            System.out.println("操作受限！");
        }
    }
}
