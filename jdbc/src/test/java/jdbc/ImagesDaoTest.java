package jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ImagesDaoTest {

    ImagesDao imagesDao;

    @BeforeEach
    void init() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/employees?useUnicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();

        flyway.clean();
        flyway.migrate();

        imagesDao = new ImagesDao(dataSource);
    }

    @Test
    void saveImageTest() throws IOException {
        imagesDao.saveImage("image.jpg",
                ImagesDaoTest.class.getResourceAsStream("/image.jpg"));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try (InputStream inputStream = imagesDao.getImageByName("image.jpg")) {
            inputStream.transferTo(baos);
        }
        assertEquals(3814, baos.size());
    }
}