package introexceptionreadfiletestjunit5;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordsTest {

    Words words = new Words();

    @Test
    void getFirstWordWithATest() {
        Path path = Paths.get("src/test/resources/words.txt");
        assertEquals("Anna", words.getFirstWordWithA(path));
    }

    @Test
    void getFirstWordWithANoSuchWordTest() {
        Path anotherPath = Paths.get("src/test/resources/wordswithouta.txt");
        assertEquals("A", words.getFirstWordWithA(anotherPath));
    }

    @Test
    void invalidFilePathTest() {
        Path wrongPath = Paths.get("src/main/resources/words.txt");
        IllegalStateException ise = assertThrows(IllegalStateException.class,
                () -> words.getFirstWordWithA(wrongPath));
        assertEquals("Can't read file!", ise.getMessage());
    }
}