package pattern.observer.java.util;

import java.util.Observable;

public class Watched extends Observable {

    public void count(int number) {
        for (; number >= 0; number--) {
            try {
                Thread.sleep(1000);
                if (number == 10) {
                    setChanged();
                }
                notifyObservers(number);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
