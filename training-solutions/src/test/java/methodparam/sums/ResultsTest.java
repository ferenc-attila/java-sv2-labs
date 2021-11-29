package methodparam.sums;

import methodparam.sums.Results;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultsTest {

    @Test
    void createTest() {
        Results results = new Results(-150.5, 247.9);

        assertEquals(-150.5, results.getSumOfNegatives());
        assertEquals(247.9, results.getSumOfPositives());
    }

}