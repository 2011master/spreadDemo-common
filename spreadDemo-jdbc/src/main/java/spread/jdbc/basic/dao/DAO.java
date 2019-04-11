package spread.jdbc.basic.dao;

import spread.jdbc.basic.util.JdbcUtil;

import java.io.IOException;
import java.sql.*;
import java.util.List;

/**
 * 更新及查询方法
 */
public class DAO {

    /**
     * 增删改
     *
     * @param sql
     * @param args
     */
    public void update(String sql, Object... args) {
        /**
         * 1，获取连接
         * 2，得到preparestatement
         * 3,赋值
         * 4，执行
         */
        try (Connection connection = JdbcUtil.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            preparedStatement.execute();
            System.out.println("更新完毕");
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public <T> T getObject(Class<T> tClass, String sql, Object... args) {

        return JdbcUtil.getSelectObjs(tClass, sql, args).get(0);

    }


    public <T> List<T> getObjects(Class<T> tClass, String sql, Object... args) {

        return JdbcUtil.getSelectObjs(tClass, sql, args);
    }

}
