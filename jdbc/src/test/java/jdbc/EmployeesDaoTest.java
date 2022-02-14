package jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
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
    }

    @Test
    void testInsertThanQuery() {
        employeesDao.createEmployee("John Doe");
        List<String> names = employeesDao.listEmployeeNames();
        assertEquals(Arrays.asList("John Doe"), names);
    }

    @Test
    void testInsertTwo() {
        employeesDao.createEmployee("John Doe");
        employeesDao.createEmployee("Jack Doe");
        assertEquals(Arrays.asList("Jack Doe", "John Doe"), employeesDao.listEmployeeNames());
    }

    @Test
    void testById() {
        long id = employeesDao.createEmployee("Jane Doe");
        String name = employeesDao.findEmployeeNameById(id);
        assertEquals("Jane Doe", name);
    }

    @Test
    void testCreateEmployees() {
        employeesDao.createEmployees(Arrays.asList("Jack Doe", "Jane Doe", "Joe Doe"));
        List<String> names = employeesDao.listEmployeeNames();
        assertEquals(Arrays.asList("Jack Doe", "Jane Doe", "Joe Doe"), names);
    }

    @Test
    void testCreateEmployeesRollback() {
        employeesDao.createEmployees(Arrays.asList("Jack Doe", "Jane Doe", "xJoe Doe"));
        List<String> names = employeesDao.listEmployeeNames();
        assertEquals(Collections.emptyList(), names);
    }
}