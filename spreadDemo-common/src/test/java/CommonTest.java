import org.junit.jupiter.api.Test;

public class CommonTest {


    @Test
    public void reflectGetInstance() throws IllegalAccessException, InstantiationException {

        Class<person> personClass = person.class;
        person person = personClass.newInstance();
        person.setAge(20);
        person.setName("zhangsanfeng");
        System.out.println(person.toString());
    }


    public static class person{
        private String name;
        private Integer age;

        public person() {
        }

        public person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}

