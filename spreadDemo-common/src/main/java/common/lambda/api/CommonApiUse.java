package common.lambda.api;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
* @desc   stream 中常用的方法使用
* @author kanggw
* @datetime 2020/4/13,12:58 下午
*/
public class CommonApiUse {

    /**
     * optional 中的 flatMap使用
     */
    public void optionalFlatMap() {


    }


    public static void main(String[] args) {
        joining();
    }

    /**
     * 拼接方法
     */
    public static void joining() {

        List<String> es = Lists.newArrayList("test1","test2","test3");

        String collect = es.stream().collect(Collectors.joining("-"));
        System.out.println(collect);

    }
}
