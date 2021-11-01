package controlselection.week;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayOfWeekTest {

    DayOfWeek dayOfWeek = new DayOfWeek();

    @Test
    void testMondayUppercase() {
        String day = "HéTFő";
        assertEquals("hét eleje", dayOfWeek.dayOfWeek(day));
    }

    @Test
    void testWednesday() {
        String day = "szerda";
        assertEquals("hét közepe", dayOfWeek.dayOfWeek(day));
    }

    @Test
    void testFriday() {
        String day = "PénTek";
        assertEquals("majdnem hétvége", dayOfWeek.dayOfWeek(day));
    }

    @Test
    void testSunday() {
        String day = "vasÁrnap";
        assertEquals("hét vége", dayOfWeek.dayOfWeek(day));
    }

    @Test
    void testDefault() {
        String day = "Wednesday";
        assertEquals("ismeretlen nap", dayOfWeek.dayOfWeek(day));
    }
}
