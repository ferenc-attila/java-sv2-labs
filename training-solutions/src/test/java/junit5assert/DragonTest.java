package junit5assert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DragonTest {

    Dragon susu = new Dragon("Süsü", 1, 3);

    @Test
    void testName() {
        assertEquals("Süsü", susu.getName());
    }

    @Test
    void testNumberOfHeads() {
        assertEquals(1, susu.getNumberOfHeads());
        assertTrue(1 == susu.getNumberOfHeads());
        assertFalse(0 > susu.getNumberOfHeads());
    }

    @Test
    void testHeight() {
        assertEquals(3.001, susu.getHeight(), 0.005);
    }

    @Test
    void testNull() {
        Dragon dragon = null;
        //Dragon dragon1 = new Dragon(null, 0, 0);

        assertNull(dragon);
        //assertNull(dragon1);
    }

    @Test
    void testSameObjects() {
        Dragon dragon = susu;
        assertSame(dragon, susu);
    }

    @Test
    void testNotSameObject() {
        Dragon dragon = new Dragon("Süsü", 1, 3);
        assertNotSame(susu, dragon);
    }
}
