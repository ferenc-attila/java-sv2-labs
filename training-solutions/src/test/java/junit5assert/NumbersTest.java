package junit5assert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class NumbersTest {

    @Test
    void testGetEvenNumbers() {
        Numbers numbers = new Numbers();
        int[] testNumbers = {25, 42, 3, 56, 8, 7, 0, 12, 5, 3, 8, 12};
        int[] expectedNumbers = {0, 42, 0, 56, 8, 0, 0, 12, 0, 0, 8, 12};

        assertArrayEquals(expectedNumbers, numbers.getEvenNumbers(testNumbers));
    }
}
