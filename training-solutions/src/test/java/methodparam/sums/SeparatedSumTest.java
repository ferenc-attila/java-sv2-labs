package methodparam.sums;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeparatedSumTest {

    @Test
    void sumTest() {
        SeparatedSum sum = new SeparatedSum();
        String floatingNumbers = sum.readTextFile(Path.of("src/test/resources/floatingnumbers.txt"));
        Results results = sum.sum(floatingNumbers);

        assertEquals(110.6, results.getSumOfPositives(), 0.0001);
        assertEquals(-153.3, results.getSumOfNegatives(), 0.0001);
    }
}