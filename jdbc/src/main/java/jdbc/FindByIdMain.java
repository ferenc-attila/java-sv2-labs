package jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindByIdMain {

    public void selectNameByPreparedStatement(PreparedStatement preparedStatement) {
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                String name = resultSet.getString("emp_name");
                System.out.println(name);
            }
            throw new IllegalArgumentException("Id not found");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query, sqle");
        }
    }

    public void selectNameById(MysqlDataSource dataSource, long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select emp_name from employees where id = ?");
        ) {
            preparedStatement.setLong(1, id);
            selectNameByPreparedStatement(preparedStatement);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    public static void main(String[] args) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/employees?useUnicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        new FindByIdMain().selectNameById(dataSource, 2L);
    }
}
