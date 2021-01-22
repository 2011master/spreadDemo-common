package pattern.observer;

import java.util.List;

public class ConcreteAllyControlCenter extends AllyControlCenter {

    @Override
    public void notifyPlays(String name) {
        playerList.stream().filter(item -> !item.getName().equals(name)).forEach(item -> {
            item.help();
        });

    }
}
