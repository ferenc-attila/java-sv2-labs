package jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectEmployeesMain {

    public static void main(String[] args) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/employees?useUnicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select emp_name from employees")
                ) {
            List<String> names = new ArrayList<>();
            while (resultSet.next()) {
                String name = resultSet.getString("emp_name");
                names.add(name);
            }
            System.out.println(names);
        } catch (SQLException sqle) {
            throw new IllegalArgumentException ("Cannot get result", sqle);
        }
    }
}
