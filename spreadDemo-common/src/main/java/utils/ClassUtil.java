package utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 关于反射的工具类
 */
public class ClassUtil {

    private static final String XML_FILE_EXTENSION = ".xml";



    /**
     * Load properties from the given resource (in ISO-8859-1 encoding).
     * @param resource the resource to load from
     * @return the populated Properties instance
     * @throws IOException if loading failed
     * @see #fillProperties(java.util.Properties, Resource)
     */
    public static Properties loadProperties(Resource resource) throws IOException {
        Properties props = new Properties();
        fillProperties(props, resource);
        return props;
    }

    /**
     * Fill the given properties from the given resource (in ISO-8859-1 encoding).
     *
     * @param props    the Properties instance to fill
     * @param resource the resource to load from
     * @throws IOException if loading failed
     */
    public static void fillProperties(Properties props, Resource resource) throws IOException {
        try (InputStream is = resource.getInputStream();) {
            String filename = resource.getFilename();
            if (filename != null && filename.endsWith(XML_FILE_EXTENSION)) {
                props.loadFromXML(is);
            } else {
                props.load(is);
            }
        }
    }


    public static <T> T getClassByPropertie(String key, String defaultValue,String path) {
        T t = null;
        try {
            Properties properties = PropertiesLoaderUtils.loadProperties(new ClassPathResource(path));
            String value = properties.getProperty(key, defaultValue);
            t = (T) Class.forName(value).newInstance();
        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return t;
    }

}
