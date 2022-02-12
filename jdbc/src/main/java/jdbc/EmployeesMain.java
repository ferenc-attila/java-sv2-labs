package jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeesMain {

    public static void main(String[] args) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/employees?useUnicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement("insert into employees(emp_name) values (?)")) {
            statement.setString(1, "Jane Doe");
            statement.executeUpdate();
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Cannot execute update statement!", sqle);
        }
    }
}
