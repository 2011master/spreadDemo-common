package jvm.kit;

import com.google.common.collect.Lists;
import com.sun.deploy.cache.Cache;

import java.util.ArrayList;

/**
* @desc    JConsole 测试类
 *     -Xms100m -Xmx100m -XX:+UseSerialGC
 *     这段代码的作用是以64KB/50ms的速度向Java堆中填充数据，一共填充1000次，使用JConsole 的“内存”页签进行监视，观察曲线和柱状指示图的变化。
* @author kanggw
* @datetime 2020/6/11,5:26 下午
*/
public class JConsole_TestCase {

    static class OOMObject{
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {

        final ArrayList<OOMObject> objects = Lists.newArrayList();

        for (int i = 0; i < num; i++) {
            //稍作延时，令监视曲线的变化更明显
            Thread.sleep(50);
            objects.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
