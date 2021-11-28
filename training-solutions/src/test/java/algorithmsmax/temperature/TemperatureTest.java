package algorithmsmax.temperature;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

    @Test
    void getMinTest() {
        List<Integer> tempList = Arrays.asList(-10, -5, 2, 12, 10, 14, 0, -12, -8, -12, -4, 5);
        Temperature temp = new Temperature();
        assertEquals(-12, temp.getMin(tempList));
    }
}