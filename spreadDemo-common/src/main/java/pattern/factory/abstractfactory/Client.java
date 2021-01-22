package pattern.factory.abstractfactory;

import pattern.factory.abstractfactory.domain.Button;

public class Client {

    public static void main(String[] args) {
        SpringSkinFactory springSkinFactory = new SpringSkinFactory();
        Button button = springSkinFactory.createButton();
        button.display();
    }
}
