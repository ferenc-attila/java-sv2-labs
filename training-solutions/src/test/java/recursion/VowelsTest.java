package recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VowelsTest {

    @Test
    void getNumberOfVowelsTest() {
        Vowels vowels = new Vowels();

        assertEquals(0, vowels.getNumberOfVowels(""));
        assertEquals(1, vowels.getNumberOfVowels("a"));
        assertEquals(0, vowels.getNumberOfVowels("b"));
        assertEquals(9, vowels.getNumberOfVowels("árvíztűrő tükörfúrógép"));
    }
}