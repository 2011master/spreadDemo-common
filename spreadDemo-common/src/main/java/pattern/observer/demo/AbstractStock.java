package pattern.observer.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 股票抽象类
 */
public abstract class AbstractStock {
    protected String stockNum;
    protected BigDecimal price;
    protected List<AbstractUser> users = new ArrayList<>();

    public AbstractStock(String stockNum) {
        this.stockNum = stockNum;
    }

    public void addUser(AbstractUser user) {
        users.add(user);
    }

    public void removeUser(AbstractUser user) {
        users.remove(user);
    }

    public abstract void notity();
}
