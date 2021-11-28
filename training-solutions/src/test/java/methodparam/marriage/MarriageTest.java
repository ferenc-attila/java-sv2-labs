package methodparam.marriage;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MarriageTest {

    @Test
    void testGetMarried() {
        RegisterDate womanBirthday = new RegisterDate("születési idő", LocalDate.parse("1981-06-11"));
        Woman woman = new Woman("Horváth Gizella", new ArrayList<>(Arrays.asList(womanBirthday)));
        RegisterDate manBirthday = new RegisterDate("születési idő", LocalDate.parse("1978-04-18"));
        Man man = new Man("Tóth János", new ArrayList<>(Arrays.asList(manBirthday)));

        Marriage marriage = new Marriage();
        marriage.getMarried(woman, man);

        assertEquals("Tóth Jánosné Horváth Gizella", woman.getName());
        assertEquals(2, man.getRegisterDates().size());
        assertEquals(LocalDate.now(), woman.getRegisterDates().get(1).getDate());
    }

}