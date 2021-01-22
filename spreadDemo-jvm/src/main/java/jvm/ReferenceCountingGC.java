package jvm;

/**
 * gc 方法执行后， 对象会被回收么？
 *
 * args : -XX:+PrintGCDateStamps -XX:+PrintGCDetails -Xloggc:./gclogs
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    //占点内存，以便在gc日志中看清楚是否有回收过
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {

        ReferenceCountingGC objA = new ReferenceCountingGC();

        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA = objB;
        objB = objA;

        objA = null;
        objB = null;

        System.gc();
    }


    public static void main(String[] args) {
        testGC();
    }

}
