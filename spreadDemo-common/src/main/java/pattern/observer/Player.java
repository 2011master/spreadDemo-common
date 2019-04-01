package pattern.observer;

public class Player implements Observer {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void help() {
        System.out.println("坚持住"+name+"来帮你");
    }

    @Override
    public void beAttacked(AllyControlCenter allyControlCenter) {
        System.out.println(name + "受到攻击");
        allyControlCenter.notifyPlays(name);
    }
}
