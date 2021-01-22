package jvm.kit;

import com.google.common.collect.Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
* @desc    JConsole 测试类
 *
* @author kanggw
* @datetime 2020/6/11,5:26 下午
*/
public class JConsole_TestCase2 {

    //线程死循环
    public static void createBusyThread() {

        Thread thread = new Thread(() -> {

            while (true) {

            }

        },"testBusyThread");

        thread.start();
    }


    //线程锁等待
    public static void createLockThread(final Object lock) {

        Thread thread = new Thread(() -> {

            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "testLockThread");

        thread.start();
    }

    public static void main(String[] args) throws IOException {

        //有两次readLine，要记得输入两次奥
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();

        createBusyThread();

        br.readLine();

        Object obj = new Object();

        createLockThread(obj);
    }
}
