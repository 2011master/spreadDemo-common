package jvm;

/**
* @desc
 *  1,对象可以在gc时自我拯救
 *  2,这种拯救机会只有一次，因为一个对象的finalize()方法最多只会被系统自动调用一次
 *  3,编程时不建议使用finalize()
* @author kanggw
* @datetime 2020/6/2,3:09 下午
*/
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {

        System.out.println("i am still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();

        System.out.println("finalize method execute");

        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {

        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次成功拯救自己
        SAVE_HOOK = null;

        System.gc();

        //因为Finalize优先级很低，暂停0.5秒，以等待它
        Thread.sleep(500);

        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("i am dead");
        }

        //下面代码与上面完全一样，但是自救却失败了
        SAVE_HOOK = null;

        System.gc();

        //因为Finalize优先级很低，暂停0.5秒，以等待它
        Thread.sleep(500);

        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("i am dead");
        }
    }
}
