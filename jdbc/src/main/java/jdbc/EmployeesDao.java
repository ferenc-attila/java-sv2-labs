package jdbc;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDao {

    private DataSource dataSource;

    public EmployeesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public long createEmployee(String name) {
        try (Connection conn = dataSource.getConnection();
             //language=sql
             PreparedStatement statement = conn.prepareStatement("insert into employees(emp_name) values (?)",
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.executeUpdate();

            return getIdByStatement(statement);
        } catch (SQLException sqle) {
            //language=sql
            throw new IllegalArgumentException("Cannot execute update statement!", sqle);
        }
    }

    private long getIdByStatement(PreparedStatement statement) {
        try (ResultSet rs = statement.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getLong(1);
            }
            throw new IllegalStateException("Cannot get id!");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot get id!");
        }
    }

    public List<String> listEmployeeNames() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             //language=sql
             ResultSet resultSet = statement.executeQuery("select emp_name from employees order by emp_name")
        ) {
            List<String> names = new ArrayList<>();
            while (resultSet.next()) {
                String name = resultSet.getString("emp_name");
                names.add(name);
            }
            return names;
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Cannot get result", sqle);
        }
    }

    public String findEmployeeNameById(long id) {
        try (Connection connection = dataSource.getConnection();
             //language=sql
             PreparedStatement preparedStatement = connection.prepareStatement("select emp_name from employees where id = ?")
        ) {
            preparedStatement.setLong(1, id);
            return selectNameByPreparedStatement(preparedStatement);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    private String selectNameByPreparedStatement(PreparedStatement preparedStatement) {
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getString("emp_name");
            }
            throw new IllegalArgumentException("Id not found");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query, sqle");
        }
    }
}
