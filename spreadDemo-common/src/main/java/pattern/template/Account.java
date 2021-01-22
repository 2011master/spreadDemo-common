package pattern.template;

import java.math.BigDecimal;

/**
 *  账户类
 */
public abstract class Account {

    public Boolean validate(String user,String pwd) {
        System.out.println("账号："+user);
        System.out.println("密码："+pwd);

        if (user.equalsIgnoreCase("zhangwuji") && pwd.equalsIgnoreCase("123456")) {
            return true;
        } else {
            return false;
        }
    }

    public abstract BigDecimal caculate();

    public void display() {
        System.out.println("显示利息");
    }

    public void handle(String user,String pwd) {
        if (!validate(user, pwd)) {
            System.out.println("用户名或密码不正确");
        }
        caculate();
        display();
    }
}
