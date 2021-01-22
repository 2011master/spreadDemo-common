package pattern.singleton;

/**
 * @author kanggw
 * @desc 懒汉式 存在风险
 * @datetime 2018/8/13,上午9:26
 */
public class LazySingletonFirst {

    private static LazySingletonFirst instance = null;

    private LazySingletonFirst() {
    }

    synchronized public static LazySingletonFirst getInstance() {
        if (null == instance) { //存在风险
            return new LazySingletonFirst();
        }
        return instance;
    }
}
