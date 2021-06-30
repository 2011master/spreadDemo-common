package pattern.singleton;

/**
* @desc  懒汉式
* @author kanggw
* @datetime 2018/8/13,上午9:26
*/
public class LazySingleton {

  private volatile static LazySingleton instance = null;

    private LazySingleton() {
        this.instance = new LazySingleton();
    }


  public static LazySingleton getInstance(){

      if (null == instance) {
          synchronized (LazySingleton.class){
              if (null == instance) {
                  instance = getInstance();
              }
          }
      }

        return instance;
  }

}
