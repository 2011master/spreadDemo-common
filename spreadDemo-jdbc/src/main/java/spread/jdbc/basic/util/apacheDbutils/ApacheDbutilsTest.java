package spread.jdbc.basic.util.apacheDbutils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import spread.jdbc.basic.domain.Person;
import spread.jdbc.basic.util.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * apache dbutils 工具类测试
 * 参考：https://commons.apache.org/proper/commons-dbutils/examples.html
 */
public class ApacheDbutilsTest {

    /**
     * 获取连接
     * 建立
     */
    public static void main(String[] args) {
//        customResultSetHandlerTest();
        beanListHandlerTest();
    }


    /**
     * 自定义ResultSetHandler
     */
    public static void customResultSetHandlerTest() {


        try(Connection connection = JdbcUtil.getConnection();) {
            QueryRunner run = new QueryRunner();
            String sql = "select * from person;";
            Object query = run.query(connection, sql, new CustomResultSetHandler());
            System.out.println("执行结果："+query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    /**
     * BeanListHandler测试
     */
    public static void beanListHandlerTest() {

        try(Connection connection = JdbcUtil.getConnection();) {
            QueryRunner run = new QueryRunner();
            String sql = "select * from person;";
            Object query = run.query(connection, sql, new BeanListHandler<Person>(Person.class));
            System.out.println("执行结果："+query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    private static ResultSetHandler<Object[]> getResultSetHandler() {
        // Create a ResultSetHandler implementation to convert the
// first row into an Object[].
        return new ResultSetHandler<Object[]>() {
            @Override
            public Object[] handle(ResultSet rs) throws SQLException {
                if (!rs.next()) {
                    return null;
                }

                ResultSetMetaData meta = rs.getMetaData();
                int cols = meta.getColumnCount();
                Object[] result = new Object[cols];

                for (int i = 0; i < cols; i++) {
                    result[i] = rs.getObject(i + 1);
                }
                return result;
            }
        };

    }
}
