package common.lambda.functionalInterface;

/**
* @desc
 * 最后咱们对于这个JAVADOC的说明对其函数数接口做一个总结：
 *
 * 1、如果一个接口只有一个抽象方法，那么该接口就是一个函数式接口。
 *
 * 2、如果我们在某个接口上声明了FunctionalInterface注解，那么编译器就会按照函数式接口的定义来要求该接口。
 *
 * 3、如果某个接口只有一个抽象方法，但我们并没有给该接口声明FuncationalInterface注解，那么编译器依旧依旧会将该接口看作是函数式接口。（虽这样说，但是一般对于函数式接口建议还是加上这个注解的比较好。因为加了之后编译器会对接口增加一个强制性的保证，如果接口不满足某些条件的话是会报错提示的，就这好比子类重写父类的一个特定方法的时候，照理是应该在子类的这个方法上增加一个override方法，但是如果不加也没问题，加了的好处一是代码可读性比较好，二是如果覆写了父类中并不存在的方法那么编译器会第一时间提示出来，所以最好按照规则来：如果满足函数式接口一定要在接口上声明FuncationalInterface注解）
 *
 * 函数式接口实例 可以由Lambda表达式，方法引用，构造引用三种方式来创建
* @author kanggw
* @datetime 2020/4/9,1:25 下午
*/
@FunctionalInterface
public interface MyInterface {

    void methodOne();

}
