package pattern.singleton;

/**
 * @author kanggw
 * @desc 懒汉式  存在风险
 * @datetime 2018/8/13,上午9:26
 */
public class LazySingletonSecond {

    private static LazySingletonSecond instance = null;

    private LazySingletonSecond() {
    }

    public static LazySingletonSecond getInstance() {
        if (null == instance) {
            //锁定代码块 存在风险
            synchronized (LazySingletonSecond.class) {
                return new LazySingletonSecond();
            }
        }
        return instance;
    }
}
