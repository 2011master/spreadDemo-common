package spread.jdbc.basic.util;

import spread.jdbc.basic.domain.Person;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
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


    public static <T> T getSelectObj(Class<T> classz,String sql,Object ... args) {
        /**
         * 1，得到connection
         * 2，得到prepareStatement
         * 3，给prepareStatement赋值
         * 4，得到resultSet
         * 5，得到metaData
         * 6，获取对象属性及对应值保存到map中
         * 7，通过反射给实例化对象赋值
         */
        Map<String, Object> contentMap = new HashMap<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ) {
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i+1,args[i]);
                }
            }
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    for (int i = 0; i < metaData.getColumnCount(); i++) {
                        Object object = resultSet.getObject(metaData.getColumnLabel(i + 1));
                        contentMap.put(metaData.getColumnLabel(i + 1), object);
                    }
                }
            }
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //赋值
        if (contentMap.size() > 0) {
            return getObject(classz, contentMap);
        }
        return null;
    }

    public static <T> T getObject(Class<T> classz,Map<String,Object> map) {
        T t = null;
        try {
            t = classz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        for (Map.Entry<String,Object> entry : map.entrySet()) {
            try {
                Field field = classz.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(t,entry.getValue());
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return t;
    }

    public static void main(String[] args) {

        String sql = "select name,age from person";
        Person selectObj = getSelectObj(Person.class, sql, null);
        System.out.println(selectObj.toString());
    }
}
