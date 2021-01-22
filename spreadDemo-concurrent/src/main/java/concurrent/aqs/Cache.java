package concurrent.aqs;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
* @desc  读写锁使用
* @author kanggw
* @datetime 2020/8/1,9:48 上午
*/
public class Cache {


    //非线程安全的HashMap作为缓存的实现
    static Map<String, Object> map = new HashMap<>();

    static ReentrantReadWriteLock rw = new ReentrantReadWriteLock();

    static Lock r = rw.readLock();

    static Lock w = rw.writeLock();

    //获取key对应value
    public static final Object get(String key) {

        r.lock();

        try {
            return map.get(key);
        }finally {
            r.unlock();
        }
    }

    //设置key对应的value并返回旧的value
    public static final Object put(String key, Object value) {

        w.lock();

        try {
            return map.put(key, value);
        }finally {
        w.unlock();
        }

    }

    //清空所有内容
    public static final void clear() {

        w.lock();

        try {
            map.clear();
        }finally {
            w.unlock();
        }
    }
}
