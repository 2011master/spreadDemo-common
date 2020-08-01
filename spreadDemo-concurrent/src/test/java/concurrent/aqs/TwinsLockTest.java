package concurrent.aqs;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.stream.IntStream;

public class TwinsLockTest {

    @Test
    public void test() throws InterruptedException {
        final Lock lock = new TwinsLock();

        class Woker extends Thread {

            public Woker() {
            }

            public Woker(String name) {
                super(name);
            }

            public void run() {
                while (true) {
                    System.out.println("before:"+Thread.currentThread().getName() + ",状态:" + Thread.currentThread().getState().name());
                    lock.lock();
                    try {
                        TimeUnit.SECONDS.sleep(1);

                        System.out.println(Thread.currentThread().getName());

                        TimeUnit.SECONDS.sleep(1);

                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }

        //启动10个线程

        for (int i = 0; i < 10; i++) {

            Woker woker = new Woker("Thread-"+i);

            woker.setDaemon(true);
            woker.start();
        }

//        IntStream.rangeClosed(0, 9).forEach( value -> {
//
//            Woker woker = new Woker("Thread-"+value);
//            woker.setDaemon(true);
//            woker.start();
//                }
//        );

        //每隔1秒换行
        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println();

        }
//        //每隔1秒换行
//        IntStream.rangeClosed(0, 9).forEach( value -> {
//
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                        System.out.println();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//        );
    }
}
