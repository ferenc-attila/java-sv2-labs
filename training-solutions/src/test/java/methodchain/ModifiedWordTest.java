package methodchain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ModifiedWordTest {

    @Test
    void modifyTest() {
        ModifiedWord modifiedWord = new ModifiedWord();

        assertEquals("AxMy", modifiedWord.modify("alma"));
        assertEquals("GxBy", modifiedWord.modify("gébics"));
        assertEquals("SxBy", modifiedWord.modify("sebesacsa"));
    }

    @Test
    void modifyTestWithShortWord() {
        ModifiedWord modifiedWord = new ModifiedWord();
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> modifiedWord.modify("ló"));

        assertEquals("The word must be at least three characters length!", iae.getMessage());
    }
}