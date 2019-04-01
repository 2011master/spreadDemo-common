package spread.jdbc.basic.util;

import spread.jdbc.basic.BasicJdbcConnection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 获取及关闭连接
 */
public class JdbcUtil {


    /**
     * 获取连接
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();

        InputStream inputStream = JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
        properties.load(inputStream);
        Class.forName(properties.getProperty("driver"));
        return DriverManager.getConnection(properties.getProperty("url"), properties);
    }

}
