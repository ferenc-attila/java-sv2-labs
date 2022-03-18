package repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import entities.Vaccination;

import javax.sql.DataSource;
import java.sql.*;

public class VaccinationDao {

    private JdbcTemplate jdbcTemplate;

    public VaccinationDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public long insertVaccination(Vaccination vaccination) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement("INSERT INTO vaccinations (client_id, vaccination_date, status, note, vaccina_type) VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, vaccination.getClient().getId());
            statement.setTimestamp(2, Timestamp.valueOf(vaccination.getVaccinationDateTime()));
            statement.setString(3, vaccination.getStatus().toString());
            statement.setString(4, vaccination.getNote());
            statement.setString(5, vaccination.getVaccineType().getName());
            return statement;
        }, holder);
        return getPrimaryKey(holder);
    }

    private long getPrimaryKey(KeyHolder holder) {
        try {
            return holder.getKey().longValue();
        } catch (NullPointerException npe) {
            throw new IllegalStateException("Cannot insert!");
        }
    }
}
