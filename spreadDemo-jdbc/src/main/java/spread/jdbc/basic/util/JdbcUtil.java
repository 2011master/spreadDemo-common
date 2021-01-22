package spread.jdbc.basic.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import spread.jdbc.basic.domain.Person;
import spread.jdbc.basic.domain.Skucost;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取及关闭连接
 */
public class JdbcUtil {


    public static DataSource dataSource = null;

    static {
        dataSource = new ComboPooledDataSource("intergalactoApp");
    }

    /**
     * 获取连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws  SQLException {
        return dataSource.getConnection();
    }


    public static <T> List<T> getSelectObjs(Class<T> classz, String sql, Object ... args) {
        /**
         * 1，得到connection
         * 2，得到prepareStatement
         * 3，给prepareStatement赋值
         * 4，得到resultSet
         * 5，得到metaData
         * 6，获取对象属性及对应值保存到map中
         * 7，通过反射给实例化对象赋值
         */
        List<T> list = new ArrayList<>();
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
                    Map<String, Object> contentMap = new HashMap<>();
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    for (int i = 0; i < metaData.getColumnCount(); i++) {
                        Object object = resultSet.getObject(metaData.getColumnLabel(i + 1));
                        contentMap.put(metaData.getColumnLabel(i + 1), object);
                    }
                    //赋值
                    if (contentMap.size() > 0) {
                        list.add(getObject(classz, contentMap));
                    }
                }
            }
        } catch ( SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 通过反射实例化一个类
     * @param classz
     * @param map
     * @param <T>
     * @return
     */
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

    /**
     * 开启事务
     * @param connection
     */
    public static void beginTransaction(Connection connection) {
        if (connection != null) {
            try {
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 提交事务
     * @param connection
     */
    public static void commitTransaction(Connection connection) {
        if (connection != null) {
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 回滚事务
     * @param connection
     */
    public static void rollbackTransaction(Connection connection) {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static<T> Class<T> getSuperGenericType(Class clazz){
        return getSuperClassGenricType(clazz, 0);
    }

    public static Class getSuperClassGenricType(Class clazz, int index){
        Type genType = clazz.getGenericSuperclass();

        if(!(genType instanceof ParameterizedType)){
            return Object.class;
        }

        Type[] params = ((ParameterizedType)genType).getActualTypeArguments();

        if(index >= params.length || index < 0){
            return Object.class;
        }

        if(!(params[index] instanceof Class)){
            return Object.class;
        }

        return (Class) params[index];
    }

    public static void main(String[] args) throws SQLException {

        String sql = "select * from skucost_1";
        final List<Skucost> selectObjs = getSelectObjs(Skucost.class, sql, null);

        System.out.println(getConnection().getClass());
    }
}
