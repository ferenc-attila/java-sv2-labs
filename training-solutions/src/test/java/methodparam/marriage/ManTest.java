package methodparam.marriage;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManTest {

    @Test
    void createTest() {
        RegisterDate registerDate = new RegisterDate("születési idő", LocalDate.parse("1978-04-18"));
        Man man = new Man("Tóth János", new ArrayList<>(Arrays.asList(registerDate)));

        assertEquals("Tóth János", man.getName());
        assertEquals(1, man.getRegisterDates().size());
        assertEquals(LocalDate.of(1978, 4, 18), man.getRegisterDates().get(0).getDate());
    }
}