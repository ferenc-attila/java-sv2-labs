package dao;

import com.mysql.cj.jdbc.MysqlDataSource;
import model.Course;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class CourseDaoTest {

    CourseDao courseDao;

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

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        courseDao = new CourseDao(dataSource);

        Course courseBeginner = new Course("Java SE alapok", "Bevezetés a Java programozási nyelv használatába", "www.training360.com");
        Course courseAdvanced = new Course("Java SE haladó", "A Java programozási nyelv eszközei", "www.training360.com");
        Course courseSpring = new Course("Bevezetés a Spring keretrendszer használatába", "Fejlesztés hatékony segédeszközei", "www.training360.com");

        courseDao.create(courseBeginner);
        courseDao.create(courseAdvanced);
        courseDao.create(courseSpring);
    }

    @Test
    void createTest() {
    Course course = new Course("Python alapok", "Bevezetés a Python programozási nyelv használatába", "www.training360.com");
    courseDao.create(course);

    Optional<Course> expected = Optional.of(new Course("Python alapok", "Bevezetés a Python programozási nyelv használatába", "www.training360.com"));

    assertEquals(expected, courseDao.get(4));
    }

    @Test
    void listTest() {
        List<Course> expected = Arrays.asList(new Course("Java SE alapok", "Bevezetés a Java programozási nyelv használatába", "www.training360.com"),
                new Course("Java SE haladó", "A Java programozási nyelv eszközei", "www.training360.com"),
                new Course("Bevezetés a Spring keretrendszer használatába", "Fejlesztés hatékony segédeszközei", "www.training360.com"));

        assertEquals(expected, courseDao.list());
    }

    @Test
    void getTest() {
        Optional<Course> expected = Optional.of(new Course("Bevezetés a Spring keretrendszer használatába", "Fejlesztés hatékony segédeszközei", "www.training360.com"));

        assertEquals(expected, courseDao.get(3));
    }

    @Test
    void updateTest() {
        courseDao.update(new Course("Python alapok", "Bevezetés a Python programozási nyelv használatába", "www.training360.com"), 1);

        Optional<Course> expected = Optional.of(new Course("Python alapok", "Bevezetés a Python programozási nyelv használatába", "www.training360.com"));

        assertEquals(expected, courseDao.get(1));
    }

    @Test
    void deleteTest() {
        courseDao.delete(1);
        List<Course> expected = Arrays.asList(new Course("Java SE haladó", "A Java programozási nyelv eszközei", "www.training360.com"),
                new Course("Bevezetés a Spring keretrendszer használatába", "Fejlesztés hatékony segédeszközei", "www.training360.com"));

        assertEquals(expected, courseDao.list());
    }
}