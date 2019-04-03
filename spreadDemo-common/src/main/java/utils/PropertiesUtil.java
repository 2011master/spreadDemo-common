package utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    public static Class getClassByPropertie(String key, String defaultValue) {
        Class<?> aClass = null;
        try {
            Properties properties = PropertiesLoaderUtils.loadProperties(new ClassPathResource("properties/test.properties"));
            String value = properties.getProperty(key, defaultValue);
            aClass = Class.forName(value);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return aClass;
    }


}
