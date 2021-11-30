package methodchain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GrasshopperTest {

    @Test
    void createTest() {
        Grasshopper grasshopper = new Grasshopper();
        assertEquals(0, grasshopper.getPosition());
    }

    @Test
    void hopOncePositiveDirectionTest() {
        Grasshopper grasshopper = new Grasshopper();
        grasshopper.hopOnce(Direction.POSITIVE);
        assertEquals(1, grasshopper.getPosition());
    }

    @Test
    void hopOnceNegativeDirectionTest() {
        Grasshopper grasshopper = new Grasshopper();
        grasshopper.hopOnce(Direction.NEGATIVE);
        assertEquals(-1, grasshopper.getPosition());
    }

    @Test
    void moveFromZeroToThreeWithFiveHopsTest() {
        Grasshopper grasshopper = new Grasshopper();
        grasshopper.moveFromZeroToThreeWithFiveHops();
        assertEquals(3, grasshopper.getPosition());
    }
}