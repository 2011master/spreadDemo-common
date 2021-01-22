package common.generic.bridgeDemo;

/**
 * 桥方法并不需要自己手动生成，一切都是编译器自动完成的。
 * 用来验证桥方法
 */
public class Child extends Parent<String> {

    public void sayHello(String t) {
        System.out.println("the child class:"+t.toString());
    }

}
