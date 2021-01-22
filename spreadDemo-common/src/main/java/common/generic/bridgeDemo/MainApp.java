package common.generic.bridgeDemo;

public class MainApp {

    public static void main(String[] args) {

        Child child = new Child();

        Parent<String> parent = child;

        parent.sayHello("this is a string");

    }
}
