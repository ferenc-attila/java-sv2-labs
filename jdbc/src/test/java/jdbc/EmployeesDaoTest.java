package jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesDaoTest {

    EmployeesDao employeesDao;

    @BeforeEach
    void init() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/employees?useUnicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();

        flyway.clean();
        flyway.migrate();

        employeesDao = new EmployeesDao(dataSource);
        employeesDao.createEmployee("John Doe");
    }

    @Test
    void testInsertThanQuery() {
        List<String> names = employeesDao.listEmployeeNames();
        assertEquals(Arrays.asList("John Doe"), names);
    }

    @Test
    void testInsertTwo() {
        employeesDao.createEmployee("Jack Doe");
        assertEquals(Arrays.asList("Jack Doe", "John Doe"), employeesDao.listEmployeeNames());
    }

    @Test
    void testById() {
        long id = employeesDao.createEmployee("Jane Doe");
        String name = employeesDao.findEmployeeNameById(id);
        assertEquals("Jane Doe", name);
    }
}