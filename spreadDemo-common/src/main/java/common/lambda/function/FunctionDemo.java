package common.lambda.function;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
* @desc   java8 中function的使用
* @author kanggw
* @datetime 2019/11/16,8:58 下午
*/
public class FunctionDemo {


    public static void main(String[] args) {
        //value -> value*20   (value表示入参，value*20  表示处理行为)
//        compute(10,value -> value*20); //输出：200
//        compute2(10,value -> value+5,value -> value*2);
//        compute3(10,100,(a,b) -> a*b);
//        predite("11111111");
        identity();
    }

    /**
     * 使用 apply方法
     * 模拟一个计算方法
     * @param a
     * @param function
     */
    public static void compute(Integer a, Function<Integer, Integer> function) {

        Integer result = function.apply(a);
        System.out.println("输出："+result);
    }

    public static void identity() {

        Function<Object, Object> identity = Function.identity();
        Object apply = identity.apply("123");
        System.out.println(apply);

    }


    /**
     * 使用 compose 方法
     * @param a
     * @param function1
     * @param function2
     */
    public static void compute2(Integer a, Function<Integer, Integer> function1,Function<Integer, Integer> function2) {
        Integer result = function1.compose(function2).apply(a);
        System.out.println("输出："+result);

    }

    /**
    * @desc  biFunction 使用  biFunction 是两个入参，一个出参
    * @author kanggw
    * @datetime 2019/11/16,9:39 下午
    */
    public static void compute3(int a, int b, BiFunction<Integer,Integer,Integer> biFunction) {

        Integer result = biFunction.apply(a, b);
        System.out.println("输出："+result);

    }

    public static void predite(String a) {

        Predicate<String> predicate = s -> s.length() > 5;
        boolean result = predicate.test(a);
        System.out.println("输出："+result);

    }


}
