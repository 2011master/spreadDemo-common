package utils;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Some JSON helper utilities.
 *
 * @author Thomas Risberg
 * @author Gunnar Hillert
 * @since 1.0
 */
public final class JsonUtil {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private final static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        //不能识别的属性不报错
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * Prevent instantiation.
     */
    private JsonUtil() {
        throw new AssertionError();
    }

    public static Map<String, Object> convertJsonToMap(String json) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        if (json != null) {
            try {
                retMap = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
                });
            } catch (IOException e) {
                logger.warn("Error while reading Java Map from JSON response: " + json, e);
            }
        }
        return retMap;
    }

    public static List<String> convertJsonToList(String json) {
        List<String> retList = new ArrayList<String>();
        if (json != null) {
            try {
                retList = mapper.readValue(json, new TypeReference<List<String>>() {
                });
            } catch (IOException e) {
                logger.warn("Error while reading Java List from JSON response: " + json, e);
            }
        }
        return retList;
    }

    /**
     * 将json串转换为指定对象list集合
     * @param json json串
     * @param tClass  要转换的对象
     * @param <T> 要转换的对象类型
     * @return arrayList
     */
    public static <T> List<T> convertJsonToList(String json, Class<T> tClass) {
        JavaType javaType = getCollectionType(ArrayList.class, tClass);
        List<T> retList = new ArrayList<T>();
        if (json != null) {
            try {
                 retList = (List<T>) mapper.readValue(json, javaType);
            } catch (IOException e) {
                logger.warn("Error while reading Java List from JSON response: " + json, e);
            }
        }
        return retList;
    }

    public static String convertToJson(Object value) {

        Assert.notNull(value, "The object to convert must not be null.");

        if (mapper.canSerialize(value.getClass())) {
            try {
                return mapper.writeValueAsString(value);
            } catch (IOException e) {
                logger.warn("Error while serializing " + value + " to JSON", e);
                return null;
            }
        } else {
            throw new IllegalArgumentException("Value of type " + value.getClass().getName()
                    + " can not be serialized to JSON.");
        }
    }

    /**
     * 将json串转为指定对象
     * @param json json字符串
     * @param clazz 要转换的对象
     * @param <T>  要转换的对象类型
     * @return 转换的对象
     */
    public static <T> T toObject(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (JsonParseException e) {
            logger.error(e.getMessage(), e);
        } catch (JsonMappingException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }


    /**
     * 获取泛型的Collection Type
     *
     * @param collectionClass 泛型的Collection
     * @param elementClasses  元素类
     * @return JavaType Java类型
     * @since 1.0
     */
    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }


}