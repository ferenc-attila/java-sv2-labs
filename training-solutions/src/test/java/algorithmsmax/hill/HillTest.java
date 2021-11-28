package algorithmsmax.hill;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HillTest {

    @Test
    void getMaxTest() {
        List<Integer> hillHeights = Arrays.asList(235, 425, 1014, 789, 2541, 8848, 8840, 5421, 4568, 1234, 256);
        Hill hill = new Hill();
        assertEquals(8848, hill.getMax(hillHeights));
    }
}