package spread.jdbc.basic.dao;

import java.sql.Connection;
import java.util.List;

/**
 * 自定义dao操作数据库
 */
public interface CustomDao<T> {


    /**
     * 执行 insert、update、delete操作
     * @param connection
     * @param sql
     * @param params
     */
    public void update(Connection connection, String sql, Object... params);

    /**
     * 获取指定对象
     * @param connection
     * @param sql
     * @param params
     * @return
     */
    public T getObject(Connection connection, String sql, Object... params);

    /**
     * 获取指定对象集合
     * @param connection
     * @param sql
     * @param params
     * @return
     */
    public List<T> getObjects(Connection connection, String sql, Object... params);

    /**
     * 获取结果，例如：平均值、总金额等
     * @param connection
     * @param sql
     * @param params
     * @param <E>
     * @return
     */
    public <E> E getResult(Connection connection, String sql, Object... params);

}
