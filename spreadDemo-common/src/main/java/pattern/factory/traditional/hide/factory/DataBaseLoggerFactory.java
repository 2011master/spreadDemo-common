package pattern.factory.traditional.hide.factory;


import pattern.factory.traditional.service.DataBaseLogger;
import pattern.factory.traditional.service.Logger;

public class DataBaseLoggerFactory extends AbstractLoggerFactory {

    @Override
    public Logger getLogger() {

        return new DataBaseLogger();
    }
}
