package controlselection.month;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayInMonthTest {

    DayInMonth dayInMonth = new DayInMonth();

    @Test
    void testThirtyDays() {
        assertEquals(30, dayInMonth.dayInMonth(2021, "ÁPRILIS"));
    }

    @Test
    void testThirtyOneDays() {
        assertEquals(31, dayInMonth.dayInMonth(2021, "DecEmbEr"));
    }

    @Test
    void testFebruaryInLeapYear() {
        assertEquals(29, dayInMonth.dayInMonth(2020, "február"));
    }

    @Test
    void testFebruaryInLeapYearDivisibleByFourHundred() {
        assertEquals(29, dayInMonth.dayInMonth(2000, "február"));
    }

    @Test
    void testFebruaryInNonLeapHundredYear() {
        assertEquals(28, dayInMonth.dayInMonth(1900, "február"));
    }

    @Test
    void testFebruaryInNonLeapYear() {
        assertEquals(28, dayInMonth.dayInMonth(2021, "február"));
    }

    @Test
    void testDefaultReturn() {
        assertEquals(0, dayInMonth.dayInMonth(2021, "January"));
    }
}
