package lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS线程安全的计数器方法safeCount和一个非线程安全的计数器count
 */
public class Counter {

    private int i = 0 ;

    private AtomicInteger atomicI = new AtomicInteger(0);

    public static void main(String[] args) {

        final Counter counter = new Counter();

        List<Thread> ts = new ArrayList<>(600);

        long start = System.currentTimeMillis();

        for (int j = 0; j < 100; j++) {

            Thread t = new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    counter.safeCount();
                    counter.count();
                }
            });

            ts.add(t);

        }

        for (Thread t : ts) {
            t.start();
        }

        //等待所有线程执行完毕
        for (Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(counter.atomicI.get());
        System.out.println(counter.i);
        System.out.println(System.currentTimeMillis() - start);
    }


    public void safeCount() {
        for (; ; ) {

            int i = atomicI.get();
            boolean b = atomicI.compareAndSet(i, ++i);
            if (b) {
                break;
            }
        }
    }

    public void count() {
        i++;
    }
}
