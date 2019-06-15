package common.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 通过反射解析注解，达到创建一个user对象的目标
 */
public class UseAnnotion {

    @CreateUserAnnotation(name = "zhangsanfeng",age = 20)
    private Object obj;


    /**
     *
     * @param obj 成员变量，其为obj类型
     * @return user对象
     * @throws NoSuchFieldException
     */
    public static User createUserByAnnotion(Field obj) throws NoSuchFieldException {

        if (obj.isAnnotationPresent(CreateUserAnnotation.class)) {
            CreateUserAnnotation annotation = obj.getAnnotation(CreateUserAnnotation.class);
            if (annotation != null) {
              return    new User(
                        annotation.id(),
                        annotation.name(),
                        annotation.age()
                );
            }
        }
        System.out.println("user 创建失败");
        return null;
    }

    public static void main(String[] args) throws NoSuchFieldException {
        Field obj = UseAnnotion.class.getDeclaredField("obj");
        User userByAnnotion = createUserByAnnotion(obj);
        System.out.println(userByAnnotion != null ? userByAnnotion.toString() : "没有获取到");
    }
}
