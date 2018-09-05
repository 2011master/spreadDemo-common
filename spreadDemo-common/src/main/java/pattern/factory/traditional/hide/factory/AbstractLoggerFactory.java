package pattern.factory.traditional.hide.factory;


import pattern.factory.traditional.service.Logger;

public abstract class AbstractLoggerFactory {

    public void writeLog() {
        this.getLogger().writeLog();
    }

    abstract Logger getLogger();
}
