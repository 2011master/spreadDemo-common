package common;

import java.sql.Connection;
import java.sql.Statement;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPoolTest {

    static ConnectionPool connectionPool = new ConnectionPool(10);

    static CountDownLatch start = new CountDownLatch(1);

    static CountDownLatch end ;

    public static void main(String[] args) throws InterruptedException {

        int threadCount = 40;

        end = new CountDownLatch(threadCount);

        int count = 20;

        AtomicInteger got = new AtomicInteger();

        AtomicInteger notGot = new AtomicInteger();

        for (int i = 0; i < threadCount; i++) {

            Thread thread = new Thread(new ConnectionRunner(count, got, notGot),"ConnectionRunnerThread");
            thread.start();

        }

        start.countDown();

        end.await();

        System.out.println("total invoke:" + threadCount * count);
        System.out.println("got:" + got);
        System.out.println("notGot:" + notGot);


    }

    static class ConnectionRunner implements Runnable{

        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {

            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {

            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (count > 0) {

                try {
                    Connection connection = connectionPool.fetchConnection(1000);
                    if (null != connection) {
                        try {
                            Statement statement = connection.createStatement();
                            connection.commit();
                        } finally {
                            connectionPool.releaseConnection(connection);
                            got.incrementAndGet();
                        }

                    } else {
                        notGot.incrementAndGet();
                    }

                } catch (Exception e) {

                    e.printStackTrace();
                }finally {
                    count --;
                }
            }

            end.countDown();
        }
    }
}
