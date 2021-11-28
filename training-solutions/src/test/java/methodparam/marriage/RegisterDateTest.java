package methodparam.marriage;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegisterDateTest {

    @Test
    void createTest() {
        RegisterDate registerDate = new RegisterDate("születési idő", LocalDate.parse("1978-04-18"));

        assertEquals("születési idő", registerDate.getDescription());
        assertEquals(LocalDate.of(1978, 4, 18), registerDate.getDate());
    }
}