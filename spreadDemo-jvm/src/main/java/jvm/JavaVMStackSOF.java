package jvm;

/**
* @desc
 * 虚拟机栈和本地方法栈溢出
 * vm args: -Xss256k
* @author kanggw
* @datetime 2020/5/28,4:20 下午
*/
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {

        stackLength ++ ;

        //递归调用
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {

        JavaVMStackSOF stackSOF = new JavaVMStackSOF();

        try {
            stackSOF.stackLeak();
        } catch (Throwable throwable) {

            System.out.println("stack length:"+ stackSOF.stackLength);

            throw throwable;
        }

        /**
         * stack length:1237
         * Exception in thread "main" java.lang.StackOverflowError
         */
    }
}
