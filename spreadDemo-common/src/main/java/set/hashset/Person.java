package set.hashset;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;

@Getter
@Setter
@ToString
public class Person {


    private String name;
    private Integer age;
    private String address;
    private double score;
    private String[] tags;

    public Person() {
    }

    public Person(String name, Integer age, String address, double score, String[] tags) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.score = score;
        this.tags = tags;
    }

    /**
     * hashCode方法设计
     * 【1】.把某个非零常数值，保存在int变量result中
     *         【2】.对于对象中每一个关键域f（指equals方法中考虑的每一个域）：
     *              【2.1】boolean型，计算（f?0:1）
     *              【2.2】byte，char，short型，计算（int）
     *              【2.3】long型，计算（int）（f ^(f >>>32)）
     *              【2.4】float型，计算Float.floatToIntBits(afloat)
     *              【2.5】double型，计算Double.doubleToLongBits(abouble)得到一个long，再执行[2.3]
     *              【2.6】对象引用，递归调用它的hashCode方法
     *              【2.7】数组域，对其中每个元素调用它的hashCode方法
     *         【3】.将上面计算得到的散列码保存到int变量c中，然后执行result=37*result +c；
     *         【4】.返回result
     */
    @Override
    public int hashCode() {

        final int PRIME = 59;
        int result = 1;
        final long temp = Double.doubleToLongBits(score);
        result = (result * PRIME) + (this.getName() == null ? 43 : this.getName().hashCode());
        result = (result * PRIME) + (this.getAddress() == null ? 43 : this.getAddress().hashCode());
        result = (result * PRIME) + (this.getAge() == null ? 43 : this.age);
        result = (result * PRIME) + (int) (temp ^ (temp >>> 32));
        result = (result * PRIME) + Arrays.deepHashCode(this.tags);

        return result;
    }

    /**
     * equals方法设计
     * 【1】.使用instanceof操作符检查“实参是否为正确的类型”。
     *
     *         【2】.对于类中的每一个“关键域”，检查实参中的域与当前对象中对应的阈值。
     *
     *             【2.1】对于非float和double类型的原语类型域，使用==比较
     *
     *             【2.2】对于对象引用域，递归调用equals方法
     *
     *             【2.3】对于float域，使用Float.floatToIntBits(afloat)转化为int，再使用==比较。
     *
     *             【2.4】对于数组域，调用Arrays.equals方法.
     */
    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person person = (Person) obj;
        if (!person.canEqual((Object) this)) {
            return false;
        }
        if (this.getName() == null ? person.getName() != null : !this.getName().equals(person.getName())) {
            return false;
        }
        if (this.getAddress() == null ? person.getAddress() != null : !this.getAddress().equals(person.getAddress())) {
            return false;
        }
        if (this.getAge() == null ? person.getAge() != null : !(this.getAge().intValue() == person.getAge().intValue())) {
            return false;
        }
        if (this.getTags() == null ? person.getTags() != null : !Arrays.equals(this.tags, person.getTags())) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {

        return other instanceof Person;
    }
}
