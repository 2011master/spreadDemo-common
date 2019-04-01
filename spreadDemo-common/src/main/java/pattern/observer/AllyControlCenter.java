package pattern.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class AllyControlCenter {

    protected String allyName;

    protected List<Observer> playerList = new ArrayList<>();

    public void join(Observer observer) {
        System.out.println(observer.getName() + "加入战队" + allyName);
        playerList.add(observer);
    };

    public void quit(Observer observer) {
        System.out.println(observer.getName()+"退出战队"+allyName);
        playerList.remove(observer);
    };

    public abstract void notifyPlays(String name);


    public String getAllyName() {
        return allyName;
    }

    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }
}
