package pattern.builder.demo2;

public class Client {

    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(null).addTopping(null).addTopping(null).build();
        Calzone calzone = new Calzone.Builder().addTopping(null).sauceInside().build();
    }
}
