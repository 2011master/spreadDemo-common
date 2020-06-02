package jvm;

/**
* @desc
 * 创建线程导致内在溢出异常
 *  这个模拟的比较困难，在mac上，线程数达到一定数量就不在增长，这个有时间在看下。
 * vm args: -Xss256M  设置每个线程的堆栈大小
* @author kanggw
* @datetime 2020/5/28,4:20 下午
*/
public class JavaVMStackOOM {

    private void dontStop() {

        while (true) {
            System.out.println( "根本停不下来！！！ thread:"+Thread.currentThread().getId());
        }
    }

    public void stackLeakByThread() {

        while (true) {

            /**
             * java8中 Runnable 增加了@FunctionalInterface 注解，是一个函数式接口了。
             * 函数式接口的实例可以由三种方式创建
             *  1，lambda 表达式
             *  2，方法引用
             *  3，构造引用（构造器）
             *  new Thread(() -> {
             *                 dontStop();
             *
             *             });
             *
             */

            //最精简的形式如下
//            Thread thread = new Thread(this::dontStop);
//
//            thread.start();
        }
    }

    public static void main(String[] args) {

        JavaVMStackOOM stackOOM = new JavaVMStackOOM();

        stackOOM.stackLeakByThread();
    }
}
