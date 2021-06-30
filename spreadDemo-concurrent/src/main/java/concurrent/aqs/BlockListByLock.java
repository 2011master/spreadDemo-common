package concurrent.aqs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockListByLock<T>{

    private static int size = 10;
    private List<T> list;

    private Lock lock ;

    private Condition fullCondition ;
    private Condition emptyCondition;

    public BlockListByLock() {

        if (size <= 0)
            throw new IllegalArgumentException();

        list = new ArrayList<>(size);
        lock = new ReentrantLock();
        fullCondition = lock.newCondition();
        emptyCondition = lock.newCondition();
    }

    public BlockListByLock(int size) {

        BlockListByLock.size = size;

        list = new ArrayList<>(BlockListByLock.size);

    }


    public void put(T t) throws InterruptedException {
        if (null == t) {
            throw new NullPointerException();
        }

        lock.lockInterruptibly();

        while (size == list.size()) {
            fullCondition.await();
        }

        list.add(t);

        emptyCondition.signal();

        //释放锁
        lock.unlock();
    }


    public T get() throws InterruptedException {

        T t;
        lock.lockInterruptibly();

        while (0 == list.size()) {
            emptyCondition.await();
        }

        t = list.remove(0);

        fullCondition.signal();

        lock.unlock();

        return t;
    }


    public static void main(String[] args) throws InterruptedException {

        BlockListByLock blockList = new BlockListByLock();

        Thread produce = new Thread(() -> {

            for (;;){
                int i = 1;
                try {
                    blockList.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("生产者生产:"+ i);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        },"生产者");

        Thread customer =  new Thread(() -> {

            for (;;){
                Object o = null;
                try {
                    o = blockList.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者得到:" + o);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        },"消费者");

        Thread monitor =  new Thread(() -> {
            for (; ; ) {

                System.out.println("queue 长度:[" + blockList.list.size() + "] 当前线程为:" + Thread.currentThread().getName());
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "监控线程");


        produce.start();
        customer.start();
        monitor.start();

        produce.join();
    }


}
