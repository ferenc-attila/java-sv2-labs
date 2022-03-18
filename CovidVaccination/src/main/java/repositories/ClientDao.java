package repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import entities.Client;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ClientDao {

    private JdbcTemplate jdbcTemplate;

    public ClientDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public long insertClient(Client client) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement("INSERT INTO clients (name, postal_code, age, email, social_security_number) VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, client.getName());
            statement.setString(2, client.getPostalCode());
            statement.setInt(3, client.getAge());
            statement.setString(4, client.getEmail());
            statement.setString(5, client.getSocialSecurityNumber());
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

    public Client getClientById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM clients WHERE id = ?",
                (rs, rowNum) -> getClient(rs));
    }

    public List<Client> getClients() {
        return jdbcTemplate.query("SELECT * FROM clients",
                (rs, rowNum) -> getClient(rs));
    }

    private Client getClient(ResultSet rs) throws SQLException {
        return new Client(rs.getLong("id"),
                rs.getString("name"),
                rs.getString("postal_code"),
                rs.getInt("age"),
                rs.getString("email"),
                rs.getString("social_security_number"),
                rs.getInt("number_of_vaccination"),
                rs.getDate("last_vaccination").toLocalDate());
    }

    public List<String> getLocationsWithRegisteredClient() {
        return jdbcTemplate.query("SELECT DISTINCT postal_code FROM clients",
                (rs, rowNum) -> rs.getString("postal_code"));
    }
}
