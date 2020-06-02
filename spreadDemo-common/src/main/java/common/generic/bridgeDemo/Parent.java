package common.generic.bridgeDemo;

import java.nio.file.Files;

/**
 * 桥方法并不需要自己手动生成，一切都是编译器自动完成的。
 * 用来验证桥方法
 */
public class Parent<T> {


    public void sayHello(T t) {

        System.out.println("this is parent class:" + t.toString());
    }
}
