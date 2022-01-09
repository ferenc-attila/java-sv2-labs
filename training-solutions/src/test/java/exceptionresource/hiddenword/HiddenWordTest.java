package exceptionresource.hiddenword;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HiddenWordTest {

    @Test
    void getHiddenWordTest() {
        Path path = Path.of("src/test/resources/hiddenword.txt");
        HiddenWord hiddenWord = new HiddenWord();

        assertEquals("ALMA KÖRTE", hiddenWord.getHiddenWord(path));
    }

    @Test
    void getHiddenWordTestInvalidFile() {
        Path path = Path.of("src/test/resources/hidden_word.txt");
        HiddenWord hiddenWord = new HiddenWord();

        IllegalStateException ise = assertThrows(IllegalStateException.class, () -> hiddenWord.getHiddenWord(path));
        assertEquals("No such file!", ise.getMessage());
    }


}