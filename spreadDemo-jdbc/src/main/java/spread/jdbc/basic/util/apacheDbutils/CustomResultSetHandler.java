package spread.jdbc.basic.util.apacheDbutils;

import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomResultSetHandler implements ResultSetHandler {
    @Override
    public Object handle(ResultSet resultSet) throws SQLException {

        return "CustomResultSetHandler";
    }
}
