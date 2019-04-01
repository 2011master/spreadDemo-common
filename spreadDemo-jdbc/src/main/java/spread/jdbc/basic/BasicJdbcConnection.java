package spread.jdbc.basic;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 创建jdbc连接
 */
public class BasicJdbcConnection {

    public static void getConnectionTest() throws SQLException {
        /**
         * 1，引入驱动包-maven
         * 2,创建driver
         * 3,获得连接
         * 4，输出连接信息
         */
        String url = "jdbc:MySQL://localhost:3306";
        String user = "root";
        String password = "123456";
        Driver driver = new com.mysql.jdbc.Driver();
        Properties properties = new Properties();
        properties.put("user", user);
        properties.put("password", password);
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
        System.out.println("测试第二个连接");
        Connection connect2 = driver.connect(url, properties);
        System.out.println(connect2);
        System.out.println("测试第三个连接");
        Connection connect3 = driver.connect(url, properties);
        System.out.println(connect3);

    }

    /**
     * 用配置文件的方式连接数据库
     */
    public static void getConnectionByResource() {
        Driver driver = null;
        Properties properties = new Properties();

        InputStream inputStream = BasicJdbcConnection.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(inputStream);
            driver  = (Driver)Class.forName(properties.getProperty("driver")).newInstance();
            Connection connect = driver.connect(properties.getProperty("url"), properties);
            System.out.println(connect);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void driverManagerTest() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Properties properties = new Properties();

        InputStream inputStream = BasicJdbcConnection.class.getClassLoader().getResourceAsStream("db.properties");
        properties.load(inputStream);

        //源码中静态代码块，可以不用注册。
//        DriverManager.registerDriver((Driver) Class.forName(properties.getProperty("driver")).newInstance());
        Class.forName(properties.getProperty("driver"));
        Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties);
        System.out.println(connection);
    }

    public static void main(String[] args) {
        //            getConnectionTest();
//        getConnectionByResource();
        try {
            driverManagerTest();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
