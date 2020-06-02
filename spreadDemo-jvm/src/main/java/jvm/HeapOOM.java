package jvm;

import com.google.common.collect.Lists;

import java.util.List;

/**
* @desc   堆内存溢出模拟
 *
 *  jvm参数：-Xms10m -Xmx10m -XX:+
 *
 *  java启动参数共分为三类；
 * 其一是标准参数（-），所有的JVM实现都必须实现这些参数的功能，而且向后兼容；
 * 其二是非标准参数（-X），默认jvm实现这些参数的功能，但是并不保证所有jvm实现都满足，且不保证向后兼容；
 * 其三是非Stable参数（-XX），此类参数各个jvm实现会有所不同，将来可能会随时取消，需要慎重使用；
 * 参考：https://www.cnblogs.com/hongdada/p/10277782.html
 *
 * 生成的堆转储文件默认路径在 jvm工作目录下，
 *
 * @author kanggw
* @datetime 2020/5/28,1:17 下午
*/
public class HeapOOM {

    static class OOMObject{}

    public static void main(String[] args) {

        final List<Object> objects = Lists.newArrayList();

        while (true) {
            objects.add(new OOMObject());
            System.out.println(objects.size());
        }
        /**
         * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
         */

    }


}
