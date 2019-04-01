package pattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {

        List products = new ArrayList();
        products.add("倚天剑");
        products.add("屠龙刀");
        products.add("碧血剑");
        products.add("割鹿刀");

        ObjectList objectList;
        AbstractIterator abstractIterator;

        objectList = new ProductList(products);
        abstractIterator = objectList.createIterator();
        iterator(abstractIterator);
        System.out.println("内部类迭代器");
        objectList = new ProductListInnerClass(products);
        abstractIterator = objectList.createIterator();
        iterator(abstractIterator);
    }

    public static void iterator(AbstractIterator abstractIterator) {

        System.out.println("正向遍历");
        while (!abstractIterator.isLast()) {
            System.out.println(abstractIterator.getNextItem());
            abstractIterator.next();
        }

        System.out.println("逆向遍历");
        while (!abstractIterator.isFirst()) {
            System.out.println(abstractIterator.getPreviousItem());
            abstractIterator.previous();
        }
    }
}
