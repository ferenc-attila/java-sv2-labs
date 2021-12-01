package initializer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RateTest {

    @Test
    void createTest() {
        Rate rate = new Rate(Currency.SFR, 389);

        assertEquals("SFR", rate.getCurrency().name());
        assertEquals(389, rate.getConversionFactor());
    }
}