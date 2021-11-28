package algorithmsdecision.words;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordTest {

    @Test
    void containsLongerWordTest() {
        Word word = new Word();
        List<String> words = Arrays.asList("répa", "retek", "mogyoró", "borsó");
        assertTrue(word.containsLongerWord(words, "kapa"));
        assertTrue(word.containsLongerWord(words, "ló"));
        assertFalse(word.containsLongerWord(words, "barna kánya"));
        assertFalse(word.containsLongerWord(words, "megszentségteleníthetetlenségeskedéseitekért"));
    }
}