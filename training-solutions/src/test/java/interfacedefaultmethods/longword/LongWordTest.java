package interfacedefaultmethods.longword;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class LongWordTest {

    @Test
    void getLongWordTest() {
        LongWord longWord = new LongWord(Path.of("src/test/resources/longword.txt"));
        assertEquals("LONGWORD", longWord.getLongWord());
    }
}