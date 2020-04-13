package pattern.observer.java.util;

import java.util.Observable;
import java.util.Observer;

public class Watcher implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        int number = (Integer) arg;
        System.out.println(number);
    }
}
