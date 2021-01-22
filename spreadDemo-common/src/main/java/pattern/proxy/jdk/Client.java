package pattern.proxy.jdk;

import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        AbstractUserDao abstractUserDao = new UserDao();

        LogHandler logHandler = new LogHandler(abstractUserDao);

        AbstractUserDao proxyInstance = (AbstractUserDao) Proxy.newProxyInstance(AbstractUserDao.class.getClassLoader(), new Class[]{AbstractUserDao.class}, logHandler);
        proxyInstance.getNameById();
        System.out.println("--end--");
    }
}
