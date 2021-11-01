package controlselection.accent;

import controlselection.accents.WithoutAccents;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WithoutAccentsTest {

    WithoutAccents withoutAccents = new WithoutAccents();

    @Test
    void withoutAccentsAccentedVowelTest() {
        assertEquals('a', withoutAccents.withoutAccents('á'));
        assertEquals('A', withoutAccents.withoutAccents('Á'));
        assertEquals('e', withoutAccents.withoutAccents('é'));
        assertEquals('E', withoutAccents.withoutAccents('É'));
        assertEquals('i', withoutAccents.withoutAccents('í'));
        assertEquals('I', withoutAccents.withoutAccents('Í'));
        assertEquals('o', withoutAccents.withoutAccents('ó'));
        assertEquals('O', withoutAccents.withoutAccents('Ó'));
        assertEquals('U', withoutAccents.withoutAccents('Ú'));
    }

    @Test
    void setWithoutAccentsDefaultValueTest() {
        assertEquals('z', withoutAccents.withoutAccents('z'));
        assertEquals('?', withoutAccents.withoutAccents('?'));
        assertEquals('Q', withoutAccents.withoutAccents('Q'));
    }
}
