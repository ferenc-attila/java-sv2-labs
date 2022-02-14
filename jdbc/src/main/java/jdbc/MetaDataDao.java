package jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetaDataDao {

    private DataSource dataSource;

    public MetaDataDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getTableNames () {
        try (Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            return getTableNamesByMetaData(metaData);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot read tablenames", sqle);
        }
    }

    private List<String> getTableNamesByMetaData(DatabaseMetaData metaData) throws SQLException {
        try (ResultSet resultSet = metaData.getTables(null, null, null, null)) {
            List<String> tableNames = new ArrayList<>();
            while (resultSet.next()) {
                String name = resultSet.getString(3);
                tableNames.add(name);
            }
            return tableNames;
        }
    }
}
