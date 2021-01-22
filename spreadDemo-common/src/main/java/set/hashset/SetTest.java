package set.hashset;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {
        String[] tags1 = {"善良", "可爱", "野蛮"};
        String[] tags2 = {"善良", "可爱"};

        Person person1 = new Person("张三疯",20,"内蒙古",23.85,tags1);
        Person person4 = new Person("张三",20,"内蒙古",23.85,tags1);
        Person person2 = new Person("张三疯",24,"内蒙古",23.85,tags1);
        Person person3 = new Person("张三疯",24,"内蒙古",58.6,tags1);
        Person person5 = new Person("张三疯",24,"内蒙古",58.6,tags2);
        //repeat
        Person person6 = new Person("张三疯",24,"内蒙古",58.6,tags2);

        Set set = new HashSet();
        set.add(person1);
        set.add(person2);
        set.add(person3);
        set.add(person4);
        set.add(person5);

        set.add(person6);
        System.out.println("===>数量：" + set.size());
        System.out.println("===>内容：" + set.toString());

    }
}
