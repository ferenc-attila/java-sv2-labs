package employees;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class EmployeesDao {

    private JdbcTemplate jdbcTemplate;

    public EmployeesDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
