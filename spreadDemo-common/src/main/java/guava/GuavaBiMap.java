package guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
* @desc   bimap 双向map测试，能根据键获取值，也能根据值获取键
* @author kanggw
* @datetime 2019/9/24,9:28 上午
*/
public class GuavaBiMap {
    /**
     * 我们知道Map是一种键值对映射，这个映射是键到值的映射，而BiMap首先也是一种Map，他的特别之处在于，既提供键到值的映射，也提供值到键的映射，所以它是双向Map.
     *
     * 想象这么一个场景，我们需要做一个星期几的中英文表示的相互映射，例如Monday对应的中文表示是星期一，同样星期一对应的英文表示是Monday。这是一个绝好的使用BiMap的场景。
     *
     * BiMap的值键对的Map可以通过inverse()方法得到。
     *
     * BiMap的常用实现有：
     *
     * HashBiMap: key 集合与 value 集合都有 HashMap 实现
     * EnumBiMap: key 与 value 都必须是 enum 类型
     * ImmutableBiMap: 不可修改的 BiMap
     */

    public static void main(String[] args) {
        BiMap<String,String> weekNameMap = HashBiMap.create();
        weekNameMap.put("星期一","Monday");
        weekNameMap.put("星期二","Tuesday");
        weekNameMap.put("星期三","Wednesday");
        weekNameMap.put("星期四","Thursday");
        weekNameMap.put("星期五","Friday");
        weekNameMap.put("星期六","Saturday");
        weekNameMap.put("星期日","Sunday");

        System.out.println("星期日的英文名是" + weekNameMap.get("星期日"));
        System.out.println("Sunday的中文是" + weekNameMap.inverse().get("Sunday"));
        /**
         * 星期日的英文名是Sunday
         * Sunday的中文是星期日
         */
    }


}
