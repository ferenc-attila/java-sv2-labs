package algorithmstransformation.letters;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoLettersTest {

    @Test
    void getFirstTwoLettersTest() {
        TwoLetters twoLetters = new TwoLetters();

        List<String> words = Arrays.asList("béka", "béna", "labda", "kérész", "békalencse", "Béla");
        List<String> firstTwoLetters = twoLetters.getFirstTwoLetters(words);

        assertEquals(6, firstTwoLetters.size());
        assertEquals("bé", firstTwoLetters.get(0));
        assertEquals("bé", firstTwoLetters.get(1));
        assertEquals("ké", firstTwoLetters.get(3));
        assertEquals("Bé", firstTwoLetters.get(5));
    }
}