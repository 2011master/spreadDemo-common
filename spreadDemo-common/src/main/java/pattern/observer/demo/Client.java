package pattern.observer.demo;

/**
 * Sunny软件公司欲开发一款实时在线股票软件，该软件需提供如下功能：当股票购买者所购买的
 *      某支股票价格变化幅度达到5%时，系统将自动发送通知（包括新价格）给购买该股票的所有股民。
 *      试使用观察者模式设计并实现该系统。
 */
public class Client {

    public static void main(String[] args) {
        AbstractUser abstractUser;
        AbstractStock abstractStock;

        abstractStock = new StockOne("0001");
        abstractUser = new UserOne("zhangsan");

        abstractStock.addUser(abstractUser);
        abstractStock.notity();
    }
}
