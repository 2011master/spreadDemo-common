package common;

import java.util.concurrent.TimeUnit;

/**
 * 创建了10个线程，编号0~9，每个线程调用前一个线程的join()方法，也就是线程0结束了，线程1才能从join()方法中返回，而线程0需要等待main线程结束。
 */
public class Join {

    public static void main(String[] args) throws InterruptedException {

        Thread pre = Thread.currentThread();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domio(pre), String.valueOf(i));
            thread.start();
            pre = thread;
        }

        TimeUnit.SECONDS.sleep(5);

        System.out.println(Thread.currentThread().getName() + "end");

    }

    static class Domio implements Runnable{

        private Thread thread;

        public Domio(Thread thread) {
            this.thread = thread;
        }
        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "end");
        }
    }
}
