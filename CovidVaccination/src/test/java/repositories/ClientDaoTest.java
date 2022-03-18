package repositories;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClientDaoTest {

    ClientDao clientDao;

    @BeforeEach
    void init() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3308/vaccination_test?useUnicode=true");
        dataSource.setUser("vaccination_test");
        dataSource.setPassword("vaccination_test");

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();

        flyway.clean();
        flyway.migrate();

        clientDao = new ClientDao(dataSource);
    }

    @Test
    void insertClient() {
    }

//    @Test
//    void getClientById() {
//    }
//
//    @Test
//    void getClients() {
//    }
//
//    @Test
//    void getLocationsWithRegisteredClient() {
//    }
}