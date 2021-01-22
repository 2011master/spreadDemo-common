package pattern.factory.traditional.service;

public class DataBaseLogger implements Logger {

    @Override
    public void writeLog() {
        System.out.println("this is DataBaseLogger!!!");
    }
}
