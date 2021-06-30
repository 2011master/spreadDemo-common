package common;

import utils.SleepUtils;

/**
 * 构建了一个常用的Profiler类，它具有begin()和end()两个方法，而end()方法返回从begin()方法调用开始到end()方法被调用时的时间差，单位是毫秒。
 */
public class Profiler {

    private static final ThreadLocal<Long> NEW_THREAD_LOCAL = new ThreadLocal<Long>() {
        protected Long intValue() {
            return System.currentTimeMillis();
        }
    };

    public static void begin() {
        NEW_THREAD_LOCAL.set(System.currentTimeMillis());
    }

    public static Long end() {

        return System.currentTimeMillis() - NEW_THREAD_LOCAL.get();
    }

    public static void main(String[] args) {
        Profiler.begin();

        SleepUtils.second(5);

        System.out.println("cost :" + Profiler.end());


    }
}
