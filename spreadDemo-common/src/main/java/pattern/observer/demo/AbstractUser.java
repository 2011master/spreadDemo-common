package pattern.observer.demo;

/**
 * 用户抽象类
 */
public abstract class AbstractUser {

    protected String name;

    public AbstractUser(String name) {
        this.name = name;
    }

    public abstract void dosometiing(String stockNum);
}
