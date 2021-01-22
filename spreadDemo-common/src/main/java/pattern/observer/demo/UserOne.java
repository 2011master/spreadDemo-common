package pattern.observer.demo;

public class UserOne extends AbstractUser {
    public UserOne(String name) {
        super(name);
    }

    @Override
    public void dosometiing(String stockNum) {
        System.out.println(name + "just to do:" + stockNum);
    }
}
