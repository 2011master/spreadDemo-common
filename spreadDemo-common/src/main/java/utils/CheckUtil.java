package utils;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 *
 * edit by zc
 *
 */
public class CheckUtil {


    /**
     * 判断一个字符串是否是null, 或者trim()之后是空字符串,
     *
     * @param s 需要判断的字符
     * @return
     */
    public static boolean isNull(String s) {
        return StringUtils.isBlank(s);
    }

    /**
     * 检验指定的数组, 如果数组中只要有一个为null, 则返回true
     *
     * @param ary 目标数组, 或变参
     * @return
     */
    @SafeVarargs
    public static <V> boolean isNull(V... ary) {
        if (ary == null) {
            return true;
        }

        if (ary.length == 0) {
            return true;
        }

        for (Object o : ary) {
            if (o == null) {
                return true;
            }
            if (o instanceof String) {
                return isNull(String.valueOf(o));
            }
        }

        return false;
    }

    /**
     * 如果容器为null, 或0长, 则返回true, 否则false
     *
     * @param c
     * @return
     */
    public static <V> boolean isNull(Collection<V> c) {
        return CollectionUtils.isEmpty(c);
    }

    /**
     * 如果容器为null, 或0长, 则返回true, 否则false
     *
     * @param <V>
     * @return
     */
    public static <K, V> boolean isNull(Map<K, V> map) {
        return MapUtils.isEmpty(map);
    }
}
