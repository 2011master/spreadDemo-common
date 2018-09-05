package set.treeset;

import java.util.TreeSet;

/**
 * TreeSet集合排序的两种方式：
 * 一，让元素自身具备比较性。
 * 也就是元素需要实现Comparable接口，覆盖compareTo 方法。
 * 这种方式也作为元素的自然排序，也可称为默认排序。
 * 二，让容器自身具备比较性，自定义比较器。
 *
 * 当Comparable比较方式，及Comparator比较方式同时存在，以Comparator为准
 *
 * https://blog.csdn.net/qq_33642117/article/details/52040345
 */
public class TreeSetCompareTest {

    public static void main(String[] args) {
        implementCompare();

    }

    public static void defaultCopare() {
        Person person1 = new Person("张三丰",25,"王家屯");
        Person person2 = new Person("张三丰",26,"王家屯");
        Person person3 = new Person("张三丰",24,"王家屯");
        Person person4 = new Person("张一丰",24,"王家屯");

        TreeSet<Person> peoples = new TreeSet<>();
        peoples.add(person1);
        peoples.add(person2);
        peoples.add(person3);
        peoples.add(person4);
        System.out.println("===>数量：" + peoples.size());
        System.out.println("===>内容：" + peoples.toString());
    }

    public static void implementCompare() {
        Person person1 = new Person("张三丰",25,"王家屯");
        Person person2 = new Person("张三丰",26,"王家屯");
        Person person3 = new Person("张三丰",24,"王家屯");
        Person person4 = new Person("张一丰",24,"王家屯");

        TreeSet peoples = new TreeSet(new CustomizeComparator());
        peoples.add(person1);
        peoples.add(person2);
        peoples.add(person3);
        peoples.add(person4);
        System.out.println("===>数量：" + peoples.size());
        System.out.println("===>内容：" + peoples.toString());

    }




}
