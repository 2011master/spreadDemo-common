package common;

import utils.SleepUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 创建了两个线程——WaitThread和NotifyThread，前者检查flag值是否为false，如果符合要求，进行后续操作，否则在lock上等待，后者在睡眠了一段时间后对lock进行通知
 *
 * WaitThread首先获取了对象的锁，然后调用对象的wait()方法，从而放弃了锁并进入了对象的等待队列WaitQueue中，进入等待状态。由于WaitThread释放了对象的锁，NotifyThread随后获取了对象的锁，并调用对象的notify()方法，将WaitThread从WaitQueue移到SynchronizedQueue中，此时WaitThread的状态变为阻塞状态。NotifyThread释放了锁之后，WaitThread再次获取到锁并从wait()方法返回继续执行。
 */
public class WaitNotify {

    static boolean flag = true;
    static Object lock =new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread wait = new Thread(new Wait(), "wait");
        wait.start();
        TimeUnit.SECONDS.sleep(1);

        Thread notify = new Thread(new Notify(), "notify");

        notify.start();
    }




    static class Wait implements Runnable{

        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    System.out.println(Thread.currentThread() + " flag is true wait" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread() + " flag is false " + new SimpleDateFormat("HH:mm:ss").format(new Date()));

            }
        }
    }

    static class Notify implements Runnable{

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " Notify hold lock  " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                SleepUtils.second(5);
            }

            synchronized (lock) {
                System.out.println(Thread.currentThread() + " Notify again lock  " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(5);

            }
        }
    }

}
