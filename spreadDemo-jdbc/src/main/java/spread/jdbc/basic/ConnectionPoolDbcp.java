package spread.jdbc.basic;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.*;

/**
 * 连接池使用 dbcp
 */
public class ConnectionPoolDbcp {

    public static void main(String[] args) {
//        useDatasource();
        useDatasource2();
     }

    /**
     * 1,得到连接池
     * 2，配置参数
     * 3，获取连接
     * 4，测试
     */

    public static DataSource getDatasource() {

        Properties properties = new Properties();
        try {
            properties.load(ConnectionPoolDbcp.class.getClassLoader().getResourceAsStream("dbcp.properties"));
            return  BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 属性测试
     * 最大连接数为5个，连接等待时间5s,同时获取6个连接时，会出Timeout异常。
     */

    public static void useDatasource()  {
        DataSource datasource = getDatasource();
        Connection connection = null;
        try {
            connection = datasource.getConnection();
            connection = datasource.getConnection();
            connection = datasource.getConnection();
            connection = datasource.getConnection();
            connection = datasource.getConnection();
            connection = datasource.getConnection();
            //出Timeout异常
            System.out.println("执行完毕");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 属性测试
     * 最大连接数为5个，连接等待时间5s,获取6个连接时，主线程获取5个，子线程获取一个，主线程3s后释放一个。
     */

    public static void useDatasource2()  {
        DataSource datasource = getDatasource();
        Connection connection = null;
        Connection connection4 = null;




        try {
            connection = datasource.getConnection();
            connection = datasource.getConnection();
            connection = datasource.getConnection();
            connection4 = datasource.getConnection();
            connection = datasource.getConnection();
            getThreadPool().execute(() -> {
                try {
                    Connection connection1 =    datasource.getConnection();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });

            Thread.sleep(3000);
            connection4.close();
            System.out.println("执行完毕");
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static ExecutorService getThreadPool() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        return  new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());


    }

}
