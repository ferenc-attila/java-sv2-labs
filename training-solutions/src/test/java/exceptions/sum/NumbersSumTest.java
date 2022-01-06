package exceptions.sum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersSumTest {

    @Test
    void validIntArrayGetSumTest() {
        NumbersSum sum = new NumbersSum();
        int[] numbers = {1,2,0,-4,8,123};
        assertEquals(130, sum.getSum(numbers));
    }

    @Test
    void nullIntArrayGetSumTest() {
        NumbersSum sum = new NumbersSum();
        int[] numbers = null;
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () ->   sum.getSum(numbers));
        assertEquals("Numbers can't be null!", iae.getMessage());
    }

    @Test
    void validStringArrayGetSumTest() {
        NumbersSum sum = new NumbersSum();
        String[] numbers = {"1","2","0","-4","8","123"};
        assertEquals(130, sum.getSum(numbers));
    }

    @Test
    void nullStringArrayGetSumTest() {
        NumbersSum sum = new NumbersSum();
        String[] numbers = null;
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () ->   sum.getSum(numbers));
        assertEquals("Numbers can't be null!", iae.getMessage());
    }

    @Test
    void invalidStringArrayGetSumTest() {
        NumbersSum sum = new NumbersSum();
        String[] numbers = {"1","2","0","-4","8","abc"};
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () ->   sum.getSum(numbers));
        assertEquals("Unable to convert the \"abc\" string to number!", iae.getMessage());
    }
}