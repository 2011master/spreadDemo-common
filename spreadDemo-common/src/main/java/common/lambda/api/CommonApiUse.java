package common.lambda.api;

import com.google.common.collect.Lists;
import utils.JsonUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
* @desc   stream 中常用的方法使用
* @author kanggw
* @datetime 2020/4/13,12:58 下午
*/
public class CommonApiUse {

    /**
     * optional 中的 flatMap使用
     */
    public void optionalFlatMap() {


    }


    public static void main(String[] args) {
//        joining();

        flatMap02();

    }

    /**
     * 拼接方法
     */
    public static void joining() {

        List<String> es = Lists.newArrayList("test1","test2","test3");

        String collect = es.stream().collect(Collectors.joining("-"));
        System.out.println(collect);

    }

    /**
     * Stream + String[] + flatMap
     * { {'a','b'}, {'c','d'}, {'e','f'} } -> flatMap -> {'a','b','c','d','e','f'}
     */
    public static void flatMap01() {

        String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        //Stream<String[]>
        Stream<String[]> temp = Arrays.stream(data);

        //Stream<String>, GOOD!
        Stream<String> stringStream = temp.flatMap(x -> Arrays.stream(x));

        Stream<String> stream = stringStream.filter(x -> "a".equals(x.toString()));

        stream.forEach(System.out::println);

		/*Stream<String> stream = Arrays.stream(data)
                .flatMap(x -> Arrays.stream(x))
                .filter(x -> "a".equals(x.toString()));*/

    }


    /**
     * Stream + Set + flatMap
     *
     */
    public static void flatMap02() {


        Student obj1 = new Student();
        obj1.setName("mkyong");
        obj1.addBook("Java 8 in Action");
        obj1.addBook("Spring Boot in Action");
        obj1.addBook("Effective Java (2nd Edition)");

        Student obj2 = new Student();
        obj2.setName("zilap");
        obj2.addBook("Learning Python, 5th Edition");
        obj2.addBook("Effective Java (2nd Edition)");

        List<Student> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);

        List<String> collect =
                list.stream()
                        .map(x -> x.getBook())      //Stream<Set<String>>
                        .flatMap(x -> x.stream())   //Stream<String>
                        .distinct()
                        .collect(Collectors.toList());

        collect.forEach(x -> System.out.println(x));

    }
}


class Student {

    private String name;
    private Set<String> book;

    public void addBook(String book) {
        if (this.book == null) {
            this.book = new HashSet<>();
        }
        this.book.add(book);
    }
    //getters and setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getBook() {
        return book;
    }

    public void setBook(Set<String> book) {
        this.book = book;
    }
}