package common.copyProperties;

import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import utils.JsonUtil;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CopyProperties {

    public static void main(String[] args) {
        testSpringBeanUtils();
        System.out.println("-------");
        testApacheBeanUtils();
    }

    public static void testSpringBeanUtils() {
        System.out.println("spring beanUtils");
        ChinesePeople chinesePeple = getChinesePeple();

        ChinesePeople chinesePeple1 = new ChinesePeople();

        UsaPeople usaPeople = new UsaPeople();

        BeanUtils.copyProperties(chinesePeple,chinesePeple1);
        System.out.println(JsonUtil.convertToJson(chinesePeple1));
        BeanUtils.copyProperties(chinesePeple,usaPeople);
        System.out.println("usaPeople:"+JsonUtil.convertToJson(usaPeople));


    }

    public static void testApacheBeanUtils() {
        System.out.println("apache beanUtils");
        ChinesePeople chinesePeple = getChinesePeple();

        ChinesePeople chinesePeple1 = new ChinesePeople();
        UsaPeople usaPeople = new UsaPeople();

        try {
            org.apache.commons.beanutils.BeanUtils.copyProperties(chinesePeple1,chinesePeple);
            System.out.println(JsonUtil.convertToJson(chinesePeple1));
            BeanUtils.copyProperties(chinesePeple,usaPeople);
            System.out.println("usaPeople:"+JsonUtil.convertToJson(usaPeople));
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }



    private static ChinesePeople getChinesePeple() {
        ChinesePeople chinesePeple = new ChinesePeople();
        chinesePeple.setName("zhangsan");
        chinesePeple.setAge(20);
        chinesePeple.setColor("huang");
        Car car = new Car(new BigDecimal(200));
        chinesePeple.setCarList(Lists.newArrayList(car));
        return chinesePeple;
    }


    public static class Person{
        private String name;
        private Integer age;

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
    }


    public static class ChinesePeople extends Person{

        private String color;

        private List<Car> carList = new ArrayList<Car>();



        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public List<Car> getCarList() {
            return carList;
        }

        public void setCarList(List<Car> carList) {
            this.carList = carList;
        }
    }

    public static class UsaPeople extends Person{

        private String color;

        private List<Car> carList = new ArrayList<Car>();



        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public List<Car> getCarList() {
            return carList;
        }

        public void setCarList(List<Car> carList) {
            this.carList = carList;
        }
    }

    public static class Car{
        private BigDecimal money;

        public Car() {
        }

        public Car(BigDecimal money) {
            this.money = money;
        }

        public BigDecimal getMoney() {
            return money;
        }

        public void setMoney(BigDecimal money) {
            this.money = money;
        }


    }




}



