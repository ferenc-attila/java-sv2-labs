package exceptions.measurement;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementTest {

    @Test
    void readFromFileTest() {
        Measurement measurement = new Measurement();
        Path path = Path.of("src/test/resources/measurementdata.csv");
        List<String> fileContent = measurement.readFromFile(path);
        assertEquals("2,12.4,John Doe,a", fileContent.get(1));
        assertEquals("9,12.4,", fileContent.get(10));
    }

    @Test
    void validateTest() {
        Measurement measurement = new Measurement();
        Path path = Path.of("src/test/resources/measurementdata.csv");
        List<String> fileContent = measurement.readFromFile(path);
        List<String> errors = measurement.validate(fileContent);
        assertEquals(8, errors.size());
        assertEquals("2,12.4,John Doe,a, 4 is invalid amount of cells!", errors.get(0));
        assertEquals("a,12.4,John Doe, a is an invalid row id!", errors.get(1));
        assertEquals("3,12a.4,John Doe, 12a.4 is an invalid measurement value!", errors.get(2));
        assertEquals("4,12.4,JohnDoe, JohnDoe is an invalid name!", errors.get(3));
        assertEquals("a1,12a.4,John Doe, a1 is an invalid row id!; 12a.4 is an invalid measurement value!", errors.get(4));
        assertEquals("9,12.4,, 2 is invalid amount of cells!", errors.get(7));
    }
}