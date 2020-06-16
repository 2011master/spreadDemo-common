package jvm;

/**
* @desc   jvm 内存分配
 *  vm args : -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
* @author kanggw
* @datetime 2020/6/8,11:48 上午
*/
public class JvmMemoryAllocation {

    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() {

        byte[] allocation1,allocation2,allocation3,allocation4;

        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        //出现 Minor GC
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
