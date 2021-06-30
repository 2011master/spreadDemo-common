package pattern.singleton;

/**
* @desc   饿汉式单例模式
* @author kanggw
* @datetime 2018/8/13,上午9:22
*/
public class HungrySingleton {

    private HungrySingleton() {

    }

    static class HolderClass{
        private final static HungrySingleton instance = new HungrySingleton();
    }

    public static HungrySingleton getInstance() {
        return HolderClass.instance;
    }

}
