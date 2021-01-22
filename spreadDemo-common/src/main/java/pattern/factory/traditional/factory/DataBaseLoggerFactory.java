package pattern.factory.traditional.factory;

import pattern.factory.traditional.service.DataBaseLogger;
import pattern.factory.traditional.service.Logger;

public class DataBaseLoggerFactory implements LoggerFactory{

    @Override
    public Logger getLogger() {

        return new DataBaseLogger();
    }
}
