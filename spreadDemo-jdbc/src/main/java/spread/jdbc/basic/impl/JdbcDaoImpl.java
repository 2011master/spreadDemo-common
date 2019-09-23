package spread.jdbc.basic.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import spread.jdbc.basic.dao.CustomDao;
import spread.jdbc.basic.util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 使用QueryRunner 实现
 * @param <T>
 */

public class JdbcDaoImpl<T> implements CustomDao<T> {

    private QueryRunner queryRunner;

    private Class<T> type;

    public JdbcDaoImpl() {
        queryRunner = new QueryRunner();
        type =JdbcUtil.getSuperGenericType(getClass());
    }

    public JdbcDaoImpl(QueryRunner queryRunner, Class<T> type) {
        this.queryRunner = queryRunner;
    }

    @Override
    public void update(Connection connection, String sql, Object... params) {

    }

    @Override
    public T getObject(Connection connection, String sql, Object... params) {

        try {
            return queryRunner.query(connection,sql,new BeanHandler<>(type),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
