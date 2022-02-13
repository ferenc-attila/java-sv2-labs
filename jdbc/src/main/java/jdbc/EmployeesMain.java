package jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.util.List;

public class EmployeesMain {

    public static void main(String[] args) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/employees?useUnicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        EmployeesDao employeesDao = new EmployeesDao(dataSource);
        employeesDao.createEmployee("Jill Doe");

        List<String> names = employeesDao.listEmployeeNames();
        System.out.println(names);

        String name = employeesDao.findEmployeeNameById(3L);
        System.out.println(name);
    }
}
