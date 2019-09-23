package spread.jdbc.basic.impl;

import org.junit.jupiter.api.Test;
import spread.jdbc.basic.domain.Person;
import spread.jdbc.basic.util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 测试
 */
class PersonDaoTest {

    @Test
    void update() {

    }

    @Test
    void getObject() throws SQLException {
        PersonDao personDao = new PersonDao();
        Connection connection = JdbcUtil.getConnection();
        String sql = "select * from person; ";
        Person person = personDao.getObject(connection, sql, null);
        System.out.println(person.toString());
    }

    @Test
    void getObjects() {
    }

    @Test
    void getResult() {
    }
}