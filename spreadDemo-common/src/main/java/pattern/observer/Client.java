package pattern.observer;

public class Client {

    public static void main(String[] args) {
        AllyControlCenter center ;

        center = new ConcreteAllyControlCenter();
        center.setAllyName("大师队");

        Observer player1,player2,player3;
        player1 = new Player("虚云");
        player2 = new Player("曾国藩");
        player3 = new Player("曾仕强");

        center.join(player1);
        center.join(player2);
        center.join(player3);

        player1.beAttacked(center);
    }
}
