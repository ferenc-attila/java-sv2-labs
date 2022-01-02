package junit5fixture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class WordsTest {

    Words words;

    @BeforeEach
    void initWords() {
    words = new Words();
    words.addWord("shrike");
    words.addWord("dove");
    words.addWord("swift");
    words.addWord("eagle");
    words.addWord("buzzard");
    words.addWord("swallow");
    words.addWord("bush-shrike");
    words.addWord("kite");
    words.addWord("swan");
    }

    @Test
    void testGetWordsStartWith() {
        List<String> expectedList = Arrays.asList ("swift", "swallow", "swan");
        words.getWordsStartWith("sw");
        assertArrayEquals(expectedList.toArray(), words.getWords().toArray());
    }

    @Test
    void testGetWordsWithLength() {
        List<String> expectedList = Arrays.asList ("dove", "kite", "swan");
        words.getWordsWithLength(4);
        assertArrayEquals(expectedList.toArray(), words.getWords().toArray());
    }
}
