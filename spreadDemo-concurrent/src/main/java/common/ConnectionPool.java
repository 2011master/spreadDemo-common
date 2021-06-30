package common;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * 使用等待超时模式来构造一个简单的数据库连接池，在示例中模拟从连接池中获取、使用和释放连接的过程，而客户端获取连接的过程被设定为等待超时的模式，
 * 也就是在1000毫秒内如果无法获取到可用连接，将会返回给客户端一个null。设定连接池的大小为10个，然后通过调节客户端的线程数来模拟无法获取连接的场景。
 */
public class ConnectionPool {

    private LinkedList<Connection> pool = new LinkedList<>();


    public ConnectionPool(int size) {

        if (size > 0) {
            for (int i = 0; i < size; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection) {

        if (null != connection) {

            synchronized (pool) {
                pool.addLast(connection);
                pool.notifyAll();
            }
        }

    }

    public Connection fetchConnection(long mills) throws InterruptedException {

        synchronized (pool) {

            if (mills < 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();


            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;

                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }

                Connection result = null;

                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }

                return result;
            }
        }

    }
}
