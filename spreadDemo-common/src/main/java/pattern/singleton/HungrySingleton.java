package pattern.singleton;

/**
* @desc   饿汉式单例模式
* @author kanggw
* @datetime 2018/8/13,上午9:22
*/
public class HungrySingleton {
    /**
     * UML 图见 https://www.processon.com/diagraming/5b6c31abe4b0edb75101f368
     */
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton( ) {
    }

    public static HungrySingleton getInstance() {

        return instance;
    }
}
