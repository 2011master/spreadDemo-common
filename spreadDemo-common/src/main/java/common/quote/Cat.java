package common.quote;

import lombok.Data;

@Data
public class Cat extends Animal {

    private String voice;

    public static void main(String[] args) {
        Cat cat = new Cat();
        Animal animal = new Animal();
        testQuoteParent(cat);
    }

    public static void testQuoteParent(Animal animal) {
        System.out.println("名称：" + animal.getName());
    }

    public static void testQuoteChild(Cat cat) {
        System.out.println("声音：" + cat.voice);

    }
}

