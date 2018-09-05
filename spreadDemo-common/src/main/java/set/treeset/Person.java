package set.treeset;

import lombok.Data;

@Data
public class Person implements Comparable{

    private String name;
    private Integer age;
    private String address;

    public Person() {
    }

    public Person(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public int compareTo(Object obj) {

        Person person = (Person) obj;
        if (this.age > person.getAge()) {
            return 1;
        }
        if (this.age < person.getAge()) {
            return -1;
        }
        return this.name.compareTo(person.getName());
    }
}
