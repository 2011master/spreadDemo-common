package pattern.factory.traditional.hide.factory;


import pattern.factory.traditional.service.FileLogger;
import pattern.factory.traditional.service.Logger;

public class FileLoggerFactory extends AbstractLoggerFactory {

    @Override
    public Logger getLogger() {

        return new FileLogger();
    }
}
