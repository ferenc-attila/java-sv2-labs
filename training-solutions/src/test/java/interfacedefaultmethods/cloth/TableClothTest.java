package interfacedefaultmethods.cloth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableClothTest {

    @Test
    void getNumberOfSidesTest() {
        TableCloth cloth = new TableCloth(5);
        assertEquals(4, cloth.getNumberOfSides());
    }

    @Test
    void getLengthOfDiagonalTest() {
        TableCloth cloth = new TableCloth(5);
        assertEquals(7.071, cloth.getLengthOfDiagonal(), 3);
    }

    @Test
    void getPerimeterTest() {
        TableCloth cloth = new TableCloth(5);
        assertEquals(20, cloth.getPerimeter());
    }

    @Test
    void getAreaTest() {
        TableCloth cloth = new TableCloth(5);
        assertEquals(25, cloth.getArea());
    }
}