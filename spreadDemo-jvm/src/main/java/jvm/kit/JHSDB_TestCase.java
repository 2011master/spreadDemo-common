package jvm.kit;

/**
* @desc   JHSDB 工具使用测试脚本
 * staticObj、instanceObj、localObj存放在哪里？
 * -Xmx10m -XX:+UseSerialGC -XX:-UseCompressedOops
* @author kanggw
* @datetime 2020/6/11,4:00 下午
*/
public class JHSDB_TestCase {

    static class Test {

        static ObjectHolder staticObj = new ObjectHolder();

        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            ObjectHolder localObj = new ObjectHolder();

            System.out.println("done");//这里设置一个断点
        }

    }

    private static class ObjectHolder{}

    public static void main(String[] args) {

        Test test = new Test();

        test.foo();
    }
}
