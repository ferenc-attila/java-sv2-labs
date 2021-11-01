package controlselection.consonant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToConsonantTest {

    ToConsonant toConsonant = new ToConsonant();

    @Test
    void testToConsonantWithIfUppercaseVowel() {
        assertEquals('F', toConsonant.toConsonant('E'));
    }

    @Test
    void testToConsonantWithIfLowercaseVowel() {
        assertEquals('p', toConsonant.toConsonant('o'));
    }

    @Test
    void testToConsonantWithIfOtherChar() {
        assertEquals('d', toConsonant.toConsonant('d'));
    }

    @Test
    void testToConsonantWithSwitchUppercaseVowel() {
        assertEquals('F', toConsonant.toConsonantWithSwitch('E'));
    }

    @Test
    void testToConsonantWithSwitchLowercaseVowel() {
        assertEquals('p', toConsonant.toConsonantWithSwitch('o'));
    }

    @Test
    void testToConsonantWithSwitchOtherChar() {
        assertEquals('d', toConsonant.toConsonantWithSwitch('d'));
    }
}
