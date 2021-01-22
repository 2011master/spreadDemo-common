package jvm;

import com.google.common.collect.Sets;

import java.util.HashSet;

/**
* @desc   方法区和运行时常量池溢出
 *  jdk6及以前 常量池在永久代中，jdk7之后 常量池被移入java堆中
 *
 *  vm args: -XX:PermSize=6M -XX:MaxPermSize=6M  jdk6
 *  vm args: -Xmx6M jdk8
* @author kanggw
* @datetime 2020/5/28,6:01 下午
*/
public class RuntimeConstantPoolOOM {


    public static void main(String[] args) {

        //使用set保持着常量池的引用，避免Full GC 回收
        HashSet<Object> set = Sets.newHashSet();

        short i = 0;

        while (true) {
            set.add(String.valueOf(i++).intern());

        }

    }
}
