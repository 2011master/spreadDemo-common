package pattern.singleton;

/**
* @desc  懒汉式
* @author kanggw
* @datetime 2018/8/13,上午9:26
*/
public class LazySingleton {
    /**
     * UML 图见 https://www.processon.com/diagraming/5b6c31abe4b0edb75101f368
     */
    //被volatile修饰的变量可确保多个线程都能够正确处理，但会屏蔽java的一些优化
    private volatile static LazySingleton instance = null;

    private LazySingleton( ) {
    }

    public static LazySingleton getInstance() {
    //双重检查锁机制
        if (null == instance) {
            //锁定代码块
            synchronized (LazySingleton.class) {
                if (null == instance) {
                    return new LazySingleton();
                }
            }
        }
        return instance;
    }
}
