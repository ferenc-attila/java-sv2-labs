package controlselection.greetings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGreetings {

    Greetings greetings = new Greetings();

    @Test
    void testMorningGreeting() {
        LocalTime morning = LocalTime.parse("06:28");
        assertEquals("Jó reggelt!", greetings.Greeting(morning));
    }

    @Test
    void testDayGreeting() {
        LocalTime day = LocalTime.parse("12:35");
        assertEquals("Jó napot!", greetings.Greeting(day));
    }

    @Test
    void testEveningGreeting() {
        LocalTime evening = LocalTime.of(19, 50);
        assertEquals("Jó estét!", greetings.Greeting(evening));
    }

    @Test
    void testNightGreeting() {
        LocalTime night = LocalTime.of(01, 05);
        assertEquals("Jó éjt!", greetings.Greeting(night));
    }
}
