package junit5fixture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShipTest {

    Ship ship;

    @BeforeEach
    void initShip() {
        ship = new Ship("Dolphin", 2012, 12.0);
    }

    @Test
    void testName() {
        assertEquals("Dolphin", ship.getName());
        assertNotEquals("Shark", ship.getName());
    }

    @Test
    void testYearOfConstruction() {
        assertEquals(2012, ship.getYearOfConstruction());
        assertTrue(2012 == ship.getYearOfConstruction());
        assertFalse(2012 != ship.getYearOfConstruction());
    }

    @Test
    void testLength() {
        assertEquals(12.004, ship.getLength(), 0.005);
    }

    @Test
    void testNull() {
        Ship anotherShip = null;
        assertNull(anotherShip);
        assertNotNull(ship);
    }

    @Test
    void testSameObject() {
        Ship anotherShip = ship;
        assertSame(ship, anotherShip);
    }

    @Test
    void testNotSame() {
        Ship anotherShip = new Ship("Dolphin", 2012, 12.0);
        assertNotSame(ship, anotherShip);
    }
}
