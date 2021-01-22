package pattern.factory.traditional.factory;

import pattern.factory.traditional.service.FileLogger;
import pattern.factory.traditional.service.Logger;

public class FileLoggerFactory implements LoggerFactory {

    @Override
    public Logger getLogger() {

        return new FileLogger();
    }
}
