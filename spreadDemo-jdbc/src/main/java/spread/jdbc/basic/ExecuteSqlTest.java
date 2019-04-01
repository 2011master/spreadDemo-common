package spread.jdbc.basic;

import spread.jdbc.basic.util.JdbcUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteSqlTest {

    public static void executeSql(String sql) {
        /**
         * 1，获取连接
         * 2，获取statement
         * 3,执行
         */
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JdbcUtil.getConnection();
            statement =  connection.createStatement();
            int i = statement.executeUpdate(sql);
            int d = 56 / 0;
            System.out.println("执行完毕："+i);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常块");
        }finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("不知道关没关");
    }

    public static void executeSql2(String sql) {
        /**
         * 1，获取连接
         * 2，获取statement
         * 3,执行
         */

        try (Connection connection = JdbcUtil.getConnection();
             Statement statement = connection.createStatement();
        ){

            int i = statement.executeUpdate(sql);
            int d = 56 / 0;
            System.out.println("执行完毕："+i);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常块");
        }
        System.out.println("不知道关没关");
    }

    public static void resultSetTest(String sql) {
        /**
         * 1，获取连接
         * 2，获取statement
         * 3,执行
         */

        try (Connection connection = JdbcUtil.getConnection();
             Statement statement = connection.createStatement();
        ){
            try(ResultSet resultSet = statement.executeQuery(sql);) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    System.out.println(id+","+name+","+age);
                }
                System.out.println("执行完毕：");

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常块");
        }
        System.out.println("不知道关没关");
    }

    public static void main(String[] args) {
        String sql ;
//        sql = "INSERT INTO person(`name`,age) VALUES('guo',26)";
//        executeSql(sql);
        sql = "select * from person";
        resultSetTest(sql);
        System.out.println("----end-----");
    }
}
