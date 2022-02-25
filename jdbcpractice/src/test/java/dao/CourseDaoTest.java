package dao;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class CourseDaoTest {

    @BeforeEach
    void init() {
        Properties properties = new Properties();
        try (InputStream is = CourseDaoTest.class.getResourceAsStream("/application.properties")) {
            properties.load(is);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot find properties file!", ioe);
        }

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(properties.getProperty("datasource.url"));
        dataSource.setUser(properties.getProperty("datasource.username"));
        dataSource.setPassword(properties.getProperty("datasource.password"));
    }

    @Test
    void listTest() {
    }

    @Test
    void createTest() {
    }

    @Test
    void getTest() {
    }

    @Test
    void updateTest() {
    }

    @Test
    void deleteTest() {
    }
}