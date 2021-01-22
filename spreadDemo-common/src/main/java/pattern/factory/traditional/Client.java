package pattern.factory.traditional;


import pattern.factory.traditional.hide.factory.AbstractLoggerFactory;
import utils.PropertiesUtil;
//uml:https://www.processon.com/diagraming/5b7382d3e4b08d3622adfaf7
public class Client {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //生成指定的日志
//        LoggerFactory loggerFactory = (LoggerFactory) PropertiesUtil
//                .getClassByPropertie("factory.class.name", "pattern.factory.traditional.factory.FileLoggerFactory")
//                .newInstance();
//        loggerFactory.getLogger().writeLog();

        AbstractLoggerFactory loggerFactory = (AbstractLoggerFactory) PropertiesUtil
                .getClassByPropertie("factory.class.name", "pattern.factory.traditional.hide.factory.FileLoggerFactory")
                .newInstance();
        loggerFactory.writeLog();
    }
}
