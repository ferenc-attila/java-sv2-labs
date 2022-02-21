package employees;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesDaoTest {

    private EmployeesDao employeesDao;

    @BeforeEach
    void init() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/employees?useUnicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();

        flyway.clean();
        flyway.migrate();

        employeesDao = new EmployeesDao(dataSource);
    }

    @Test
    void createEmployeeTest() {
        employeesDao.createEmployee("John Doe");

        List<String> names = employeesDao.listEmployeeNames();

        assertEquals(List.of("John Doe"), names);
    }

    @Test
    void findByIdTest() {
        long id = employeesDao.createEmployee("John Doe");

        String name = employeesDao.findEmployeeNameById(id);
        assertEquals("John Doe", name);
    }
}