package spread.jdbc.basic.dao;

import spread.jdbc.basic.domain.Person;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DAOTest {



    @org.junit.jupiter.api.Test
    void update() {
        String sql = "insert into person(name,age) values(?,?)";
        DAO dao = new DAO();
        dao.update(sql,"zhangsan",25);

    }

    @org.junit.jupiter.api.Test
    void getObject() {
        DAO dao = new DAO();
        String sql = "select name,age from person";
        Person person = dao.getObject(Person.class, sql, null);
        System.out.println(person.toString());
    }

    @org.junit.jupiter.api.Test
    void getObjects() {
        DAO dao = new DAO();
        String sql = "select name,age from person";
        List<Person> persons = dao.getObjects(Person.class, sql, null);
        persons.forEach(item -> {
            System.out.println(item.toString());
        });

    }
}