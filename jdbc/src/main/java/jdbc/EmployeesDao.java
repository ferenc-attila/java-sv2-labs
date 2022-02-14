package jdbc;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
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

    public void createEmployees(List<String> names) {
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            insertNames(names, connection);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot insert", sqle);
        }
    }

    private void insertNames(List<String> names, Connection connection) throws SQLException {
        //language=sql
        try (PreparedStatement statement = connection.prepareStatement("insert into employees(emp_name) values(?)")) {
            for (String name : names) {
                if (name.startsWith("x")) {
                    throw new IllegalArgumentException("Invalid name");
                }
                statement.setString(1, name);
                statement.executeUpdate();
            }
            connection.commit();
        } catch (IllegalArgumentException iae) {
            connection.rollback();
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

    public List<String> listOddEmployeeNames() {
        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ResultSet resultSet = statement.executeQuery("select emp_name from employees order by emp_name")
        ) {
            if (!resultSet.next()) {
                return Collections.emptyList();
            }
            List<String> names = new ArrayList<>();
            names.add(resultSet.getString("emp_name"));
            while (resultSet.relative(2)) {
                names.add(resultSet.getString("emp_name"));
            }
            return names;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot list names", sqle);
        }
    }

    public void updateNames() {
        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                ResultSet resultSet = statement.executeQuery("select id, emp_name from employees")
        ) {
            while (resultSet.next()) {
                String name = resultSet.getString("emp_name");
                if (!name.startsWith("Jane")) {
                    resultSet.updateString("emp_name", "Mr. " + name);
                    resultSet.updateRow();
                }
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot read names");
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
