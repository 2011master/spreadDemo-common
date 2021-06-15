package common;

import utils.SleepUtils;

import java.util.concurrent.TimeUnit;

/**
 * 首先创建了两个线程，SleepThread和BusyThread，前者不停地睡眠，后者一直运行，然后对这两个线程分别进行中断操作，观察二者的中断标识位。
 */
public class Interrupted {


    public static void main(String[] args) throws InterruptedException {

        Thread sleep = new Thread(new SleepRunner(), "sleepRuuner");

        sleep.setDaemon(true);

        Thread busy = new Thread(new BusyRunner(), "busyRunner");
        busy.setDaemon(true);

        sleep.start();
        busy.start();

        TimeUnit.SECONDS.sleep(5);

        sleep.interrupt();
        busy.interrupt();

        System.out.println("sleep interrupt is" + sleep.isInterrupted());
        System.out.println("busy interrupt is" + busy.isInterrupted());

        TimeUnit.SECONDS.sleep(2);
    }



    static class SleepRunner implements Runnable{


        @Override
        public void run() {
            while (true) {
                SleepUtils.second(10);
            }
        }
    }

    static class BusyRunner implements Runnable{

        @Override
        public void run() {
            while (true) {

            }
        }
    }
}
