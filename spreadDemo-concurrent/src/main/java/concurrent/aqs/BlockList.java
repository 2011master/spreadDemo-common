package concurrent.aqs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现阻塞的arrylist
 *
 * 1.通过 synchronized, wait(),notify()实现等待通知模型
 * 2. 通过 lock, condition 实现等待通知模型
 *
 */
public class BlockList<T> {


    private static int size = 3;
    private List<T> list;

    public BlockList() {
        if (size <= 0)
            throw new IllegalArgumentException();

        list = new ArrayList(size);
    }

    public BlockList(int size) {

        BlockList.size = size;
        list = new ArrayList(size);

    }

    public void put(T t) {
        if (null == t) {
            throw new NullPointerException();
        }
        synchronized (BlockList.class) {
            while (size == list.size()) {
                try {
                    System.out.println("list已满,thread:"+Thread.currentThread().getName());
                    BlockList.class.wait();
                } catch (InterruptedException e) {
                    System.out.println("put error !!!");
                }
            }
            list.add(t);
            //通知
            BlockList.class.notify();
        }

    }


    public T get() {

        T t;
        synchronized (BlockList.class) {
            while (0 == list.size()) {
                try {
                    System.out.println("list为空,thread:"+Thread.currentThread().getName());
                    BlockList.class.wait();
                } catch (InterruptedException e) {
                    System.out.println("get error!!!");
                }
            }

            t = list.remove(0);

            //通知
            BlockList.class.notify();
        }

        return t;
    }


    public static void main(String[] args) throws InterruptedException {

        BlockList blockList = new BlockList(5);

        Thread produce = new Thread(() -> {

            for (;;){
                int i = 1;
                blockList.put(i);
                System.out.println("生产者生产:"+ i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        },"生产者");

        Thread customer =  new Thread(() -> {

           for (;;){
               Object o = blockList.get();
               System.out.println("消费者得到:" + o);
               try {
                   Thread.sleep(100);
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

        Thread.sleep(500);

        produce.start();
        customer.start();
        monitor.start();

        produce.join();
    }





}


