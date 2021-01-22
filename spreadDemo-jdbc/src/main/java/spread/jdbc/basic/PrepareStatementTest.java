package spread.jdbc.basic;

import spread.jdbc.basic.util.JdbcUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * prepareStatement 使用
 */
public class PrepareStatementTest {


    public static void executeSql(String sql,Object ... args) {
        /**
         * 1，获取连接
         * 2，准备sql
         * 3,获取prepareStatement
         * 4,执行
          */

        try(Connection connection = JdbcUtil.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 1; i <= args.length; i++) {
                preparedStatement.setObject(i,args[i-1]);
            }
            int i = preparedStatement.executeUpdate();
            System.out.println("执行完毕："+i);

        } catch (  SQLException e) {
            e.printStackTrace();
        }

    }



    public static void main(String[] args) {
        String sql = "insert into person(name,age) values(?,?)";
        String name = "test";
        int age = 20;
        executeSql(sql,name,age);
    }


}
