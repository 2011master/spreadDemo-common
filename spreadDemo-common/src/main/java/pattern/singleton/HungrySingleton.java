package pattern.singleton;

/**
* @desc   饿汉式单例模式
* @author kanggw
* @datetime 2018/8/13,上午9:22
*/
public class HungrySingleton {

    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton( ) {
    }

    public static HungrySingleton getInstance() {

        return instance;
    }
}
