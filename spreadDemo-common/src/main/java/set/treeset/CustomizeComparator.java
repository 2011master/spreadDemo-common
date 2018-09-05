package set.treeset;

import java.util.Comparator;

/**
 * 自定义比较器
 */
public class CustomizeComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        Person person1 = (Person) o1;
        Person person2 = (Person) o2;

        if (person1.getAge() > person2.getAge()) {
            return 1;
        }

        if (person1.getAge() < person2.getAge()) {
            return -1;
        }

        return person1.getName().compareTo(person2.getName());
    }
}
