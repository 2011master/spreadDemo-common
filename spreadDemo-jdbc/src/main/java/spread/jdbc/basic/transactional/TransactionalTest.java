package spread.jdbc.basic.transactional;

import spread.jdbc.basic.util.JdbcUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * jdbc事务处理流程测试
 */
public class TransactionalTest {


    public static void update(Connection connection, List<String> sqls, Object... args) {
        /**
         * 1，关闭mysql自动提交事务
         * 2，手动提交
         * 3,遇到异常回滚
         */
        try {
            connection.setAutoCommit(false);
            for (String sql : sqls) {
                try(PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
                    for (int i = 0; i < args.length; i++) {
                        preparedStatement.setObject(i + 1, args[i]);
                    }
                    preparedStatement.execute();
                    System.out.println("更新完毕");
                    throw new RuntimeException("手动抛出");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        List<String> sqls = new ArrayList<>();
        String sql1 = "update person set  age= age + 2 where id = 2;";
        String sql2 = "update person set  age= age - 2 where id = 3;";
        sqls.add(sql1);
        sqls.add(sql2);

        try(Connection connection = JdbcUtil.getConnection();) {
            update(connection,sqls);

        } catch (  SQLException e) {
            e.printStackTrace();
        }
    }
}
