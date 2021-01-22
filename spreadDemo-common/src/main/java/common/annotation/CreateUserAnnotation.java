package common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @desc
 *  本demo演示注解的使用方法，注解的用处就是通过反射获取到指定注解然后添加你想实现的功能，
 *  不要问注解能什么，你想干什么？
 *
 *  这个demo演示的场景为：将一个object属性，通过解析注解的方式得到一个user对象，并实例化
 *
* @author kanggw
* @datetime 2019-06-15,15:06
*/
//说明是用在成员变量上的
@Target(ElementType.FIELD)
//说明在代码运行时都可以解析得到
@Retention(RetentionPolicy.RUNTIME)
public @interface CreateUserAnnotation {

    /**
     * 定义注解的属性
     */
    public int id() default 0;
    public String name() ;
    public int age() default 18 ;

}
