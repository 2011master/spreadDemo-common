package spread.jdbc.basic.impl;

import org.apache.commons.dbutils.QueryRunner;
import spread.jdbc.basic.dao.CustomDao;

import java.sql.Connection;
import java.util.List;

/**
 * 使用QueryRunner 实现
 * @param <T>
 */

public class JdbcDaoImpl<T> implements CustomDao<T> {

    private QueryRunner queryRunner;

    private Class<T> type;

    public JdbcDaoImpl() {
    }

    public JdbcDaoImpl(QueryRunner queryRunner, Class<T> type) {
        this.queryRunner = queryRunner;
    }

    @Override
    public void update(Connection connection, String sql, Object... params) {

    }

    @Override
    public T getObject(Connection connection, String sql, Object... params) {
        return null;
    }

    @Override
    public List<T> getObjects(Connection connection, String sql, Object... params) {
        return null;
    }

    @Override
    public <E> E getResult(Connection connection, String sql, Object... params) {
        return null;
    }


}
