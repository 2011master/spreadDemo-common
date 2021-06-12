package lock;

/**
 * 如果发现死锁,当出现死锁时程序便不能提供服务了,业务能够感知到,需要通过dump去检查具体原因
 *
 * 1. 找到当前jvm线程 ,通过 jps -l
 * D:\1kanggw\project\spreadDemo-common>jps -l
 * 7088 org.jetbrains.idea.maven.server.RemoteMavenServer36
 * 10760
 * 13880 lock.DeadLockDemo
 * 7064 sun.tools.jps.Jps
 * 6460
 *
 * 可以看到13880 便是当前程序线程id
 *
 * 通过 jstack -l 13880 查询栈信息,有类似信息
 * Found one Java-level deadlock:
 * =============================
 * "Thread-1":
 *   waiting to lock monitor 0x0000000008052248 (object 0x00000000d6fbafa0, a java.lang.String),
 *   which is held by "Thread-0"
 * "Thread-0":
 *   waiting to lock monitor 0x00000000080536e8 (object 0x00000000d6fbafd0, a java.lang.String),
 *   which is held by "Thread-1"
 *
 * Java stack information for the threads listed above:
 *
 *
 */
public class DeadLockDemo {


    private static String A = "A";

    private static String B = "B";


    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    private void deadLock() {

        Thread t1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A){
                    try {
                        Thread.currentThread().sleep(20000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println(1);
                    }
                }
            }
        });

        Thread t2 = new Thread(() ->{
            synchronized (B) {
                synchronized (A){
                    System.out.println(2);
                }
            }
        });

        t1.start();
        t2.start();
    }


}
