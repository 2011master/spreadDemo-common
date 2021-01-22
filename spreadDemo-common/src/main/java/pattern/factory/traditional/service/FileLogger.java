package pattern.factory.traditional.service;

public class FileLogger implements Logger {

    @Override
    public void writeLog() {
        System.out.println("this is FileLogger!!!");
    }
}
