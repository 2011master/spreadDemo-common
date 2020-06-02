package jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
* @desc   直接内存溢出
 * vm args: -Xmx20M -XX:MaxDirectMemorySize=10M
* @author kanggw
* @datetime 2020/5/29,8:22 下午
*/
public class DirectMemoryOOM {

    // 1 G
    private static final int memory = 1024 * 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {

        final Field declaredField = Unsafe.class.getDeclaredFields()[0];

        declaredField.setAccessible(true);

        Unsafe unsafe = (Unsafe) declaredField.get(null);

        int i = 0;
        while (true) {
            System.out.println(i++);
            unsafe.allocateMemory(memory);
        }


    }
}
