package spread.jdbc.basic;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.*;

/**
 * 连接池使用 c3p0
 */
public class ConnectionPoolC3p0 {

    public static void main(String[] args) {
        getDatasource();
     }

    /**
     * 1,得到连接池
     * 2，配置参数
     * 3，获取连接
     * 4，测试
     */

    public static DataSource getDatasource() {

        return new ComboPooledDataSource("intergalactoApp");

    }





}
