package pattern.template;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class Client {

    public static void main(String[] args) {
        Account account;
        String user = "zhangwuji";
        String pwd = "123456";

//        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("accountInfo.properties");
//        Properties properties = new Properties();
//        try {
//            properties.load(inputStream);
//            account = (Account) Class.forName(properties.getProperty("accountName")).newInstance();
//            account.handle(user,pwd);
//        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
//            e.printStackTrace();
//        }
        account = new CurrentAccount();
        account.handle(user,pwd);

    }

    public void getFile() {
        URL resource = getClass().getClassLoader().getResource("accountInfo.properties");
        System.out.println(resource.toString());
    }

}

