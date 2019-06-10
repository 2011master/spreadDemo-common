package spread.jdbc.basic;

import com.google.common.base.Stopwatch;
import spread.jdbc.basic.util.JdbcUtil;

import java.io.IOException;
import java.sql.*;

/**
 * jdbc批量插入性能测试
 * 插入10w条数据， mysql 差别不明显，oracle差别明显
 * */
public class BatchJdbc {


    public static void main(String[] args) {
//         useStatement();
//        usePrestatement();
        usePrestatementBatch();
    }

    /**
     * 使用statement，不批量
     */

    public static void useStatement() {
        Connection connection= null;
        Stopwatch stopwatch = Stopwatch.createStarted();

        try  {
             connection = JdbcUtil.getConnection();
            JdbcUtil.beginTransaction(connection);
            Statement statement = connection.createStatement();
            for (int i = 0; i < 100000;i++) {
                String sql = "insert into customer( name, address, create_time)  values ('name2"+(i+1)+"','address2"+(i+1)+"','2019-06-01 08:30:42')";
                statement.executeUpdate(sql);
            }
            JdbcUtil.commitTransaction(connection);
            System.out.println("执行完毕："+stopwatch.stop());
            //执行完毕：1.610 min
        } catch (SQLException  e) {
            e.printStackTrace();
            JdbcUtil.rollbackTransaction(connection);
        }
    }

    /**
     * 使用usePrestatement ,不批量
     */
    public static void usePrestatement() {
        Connection connection= null;
        Stopwatch stopwatch = Stopwatch.createStarted();

        try  {
            connection = JdbcUtil.getConnection();
            JdbcUtil.beginTransaction(connection);
            String sql = "insert into customer( name, address, create_time)  values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < 100000;i++) {
                preparedStatement.setString(1,"name"+(i+1));
                preparedStatement.setString(2,"address"+(i+1));
                preparedStatement.setDate(3,new Date(new java.util.Date().getTime()));
                preparedStatement.executeUpdate();
            }
            JdbcUtil.commitTransaction(connection);
            System.out.println("执行完毕："+stopwatch.stop());
            //执行完毕：37.63 s
        } catch (  SQLException  e) {
            e.printStackTrace();
            JdbcUtil.rollbackTransaction(connection);
        }
    }

    /**
     * 使用usePrestatement ,批量
     */
    public static void usePrestatementBatch() {
        Connection connection= null;
        Stopwatch stopwatch = Stopwatch.createStarted();

        try  {
            connection = JdbcUtil.getConnection();
            JdbcUtil.beginTransaction(connection);
            String sql = "insert into customer( name, address, create_time)  values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < 100000;i++) {
                preparedStatement.setString(1,"name"+(i+1));
                preparedStatement.setString(2,"address"+(i+1));
                preparedStatement.setDate(3,new Date(new java.util.Date().getTime()));

                preparedStatement.addBatch();
                if ((i + 1) % 600 == 0) {
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();
                }
            }
            if (100000 % 600 != 0) {
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
            JdbcUtil.commitTransaction(connection);
            System.out.println("执行完毕："+stopwatch.stop());
            //执行完毕：37.38 s
        } catch (  SQLException  e) {
            e.printStackTrace();
            JdbcUtil.rollbackTransaction(connection);
        }
    }

}
