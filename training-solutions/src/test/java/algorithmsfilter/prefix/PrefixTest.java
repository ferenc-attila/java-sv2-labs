package algorithmsfilter.prefix;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrefixTest {

    @Test
    void getWordsStartWithTest() {
        Prefix prefix = new Prefix();
        List<String> words = Arrays.asList("béka", "béna", "labda", "kérész", "békalencse", "Béla");
        List<String> wordsStartWithPrefix = prefix.getWordsStartWith(words, "bé");

        assertEquals(3, wordsStartWithPrefix.size());
        assertTrue(wordsStartWithPrefix.contains(words.get(0)));
        assertFalse(wordsStartWithPrefix.contains(words.get(2)));
        assertFalse(wordsStartWithPrefix.contains(words.get(5)));
    }
}