package jvm;

/**
* @desc   对长期存活对象将进入老年代进行验证
 *
 * vm args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX：MaxTenuringThreshold=1
* @author kanggw
* @datetime 2020/6/8,7:43 下午
*/
public class TenuringThreshold {

    private static final int _1MB = 1024 * 1024;

    public static void testTenuringThreshold() {

        byte[] allocation1,allocation2,allocation3;

        // 什么时候进入老年代决定于XX:MaxTenuring-Threshold设置

        allocation1 = new byte[_1MB / 4];

        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];

    }

    public static void main(String[] args) {
//        testTenuringThreshold();

        while (true) {

        }
    }
}
