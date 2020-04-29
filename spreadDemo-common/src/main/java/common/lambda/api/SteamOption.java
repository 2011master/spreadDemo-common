package common.lambda.api;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
* @desc   此demo演示在使用流的过程中操作流
 *          通常是不建议这么做的
* @author kanggw
* @datetime 2020/4/21,8:38 下午
*/
public class SteamOption {

    public static void main(String[] args) {

        optionTwo();
    }

    /**
     * 这个虽然可以执行，但不建议这么做
     */
    public static void optionOne() {

        ArrayList<String> strings = Lists.newArrayList("test1", "test2", "test3");

        Stream<String> stream = strings.stream();

        strings.add("test4");

        long count = stream.distinct().count();

        System.out.println("out:" + count); //out:4
    }

    public static void optionTwo() {

        ArrayList<String> strings = Lists.newArrayList("test1", "test2", "test3");

        Stream<String> stream = strings.stream();

        stream.forEach( item -> {
            System.out.println("item:"+ item);
            if (item.length() < 10) strings.remove(item); //java.lang.NullPointerException
        });

    }
}
