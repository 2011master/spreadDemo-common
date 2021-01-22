package common.lambda.functionalInterface;

/**
 * 既然Lambda表达式是一个对象，而且必须依附于一类特别的对象类型叫函数式接口，那么如果咱们给出了一个Lambda表达式，那这个表达式对应一个什么样的函数式接口呢？答案是：这个类型的判定必须依附于上下文，如果没有给出上下文，那么仅凭这个Lambda表达式是无法得知其具体是什么类型的，下面用代码来阐述一下：
 */
public class Test {

    public static void main(String[] args) {
        MyInterface1 myInterface1 = ()->{};

        System.out.println(myInterface1.getClass().getInterfaces()[0]);

        MyInterface2 myInterface2 = ()->{};

        System.out.println(myInterface2.getClass().getInterfaces()[0]);

        /**
         * 而如果木有上下文的Lambda表达式它到底是啥类型的，编译器是无法断定出来的，所以就会报错了。上下文这也是Java编译器对于Lambda表达式类型推断的一个非常重要的依据，实际上它就是去找目标函数式接口特定唯一的抽象方法，然后再找到抽象方法的参数、抽象方法的返回类型，而关于抽象方法到底是什么名字，对于Lambda表达式是毫无意义的：
         */
        //单独写则报错
//        ()->{};
    }

}


@FunctionalInterface
interface MyInterface1 {

    void methodOne();

}

@FunctionalInterface
interface MyInterface2 {

    void methodOne();

}