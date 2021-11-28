package algorithmsdecision.towns;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TownTest {

    @Test
    void containsFewerHabitantsTest() {
        Town town = new Town();
        List<Integer> populations = Arrays.asList(751, 1245, 827, 14322, 2_001_234, 125_324, 1_745_235, 1897, 15_632_458);
        assertFalse(town.containsFewerHabitants(populations, 751));
        assertFalse(town.containsFewerHabitants(populations, 0));
        assertTrue(town.containsFewerHabitants(populations, 1000));
        assertTrue(town.containsFewerHabitants(populations, 16_000_000));
        assertTrue(town.containsFewerHabitants(populations, 752));
    }
}