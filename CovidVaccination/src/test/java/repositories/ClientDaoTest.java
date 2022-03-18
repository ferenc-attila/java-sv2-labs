package repositories;

import com.mysql.cj.jdbc.MysqlDataSource;
import entities.Client;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientDaoTest {

    ClientDao clientDao;
    List<Client> clients;

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
        clients = Arrays.asList(new Client("Jane Doe", "2030", 24, "janed@example.com", "123456788"),
                new Client("Jill Doe", "2030", 35, "jilld@example.com", "341256788"),
                new Client("Jack Doe", "3300", 89, "jackd@example.com", "563412788"));
        clients.forEach(client -> clientDao.insertClient(client));
    }

    @Test
    void insertClient() {
        Client client = new Client("John Doe", "3300", 45, "johnd@example.com", "783456128");
        long clientId = clientDao.insertClient(client);
        assertEquals("John Doe", clientDao.getClientById(4).getName());
    }

    @Test
    void getClientById() {
        assertEquals("Jane Doe", clientDao.getClientById(1).getName());
    }

    @Test
    void getClients() {
        assertEquals(3, clientDao.getAllClients().size());
        assertEquals("Jane Doe", clientDao.getAllClients().get(0).getName());
        assertEquals("jackd@example.com", clientDao.getAllClients().get(2).getEmail());
    }

    @Test
    void getLocationsWithRegisteredClient() {
        assertEquals(2, clientDao.getLocationsWithRegisteredClient().size());
        Client client = new Client("John Doe", "2074", 45, "johnd@example.com", "783456128");
        long clientId = clientDao.insertClient(client);
        assertEquals(3, clientDao.getLocationsWithRegisteredClient().size());
    }
}