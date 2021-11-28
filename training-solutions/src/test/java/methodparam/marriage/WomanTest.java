package methodparam.marriage;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WomanTest {

    @Test
    void createTest() {
        RegisterDate registerDate = new RegisterDate("születési idő", LocalDate.parse("1978-04-18"));
        Woman woman = new Woman("Horváth Gizella", new ArrayList<>(Arrays.asList(registerDate)));

        assertEquals("Horváth Gizella", woman.getName());
        assertEquals(1, woman.getRegisterDates().size());
        assertEquals(LocalDate.of(1978, 4, 18), woman.getRegisterDates().get(0).getDate());
    }
}