package controladvanced.labels;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LabelsTest {

    Labels labels;

    @BeforeEach
    void initTable() {
        labels = new Labels();
    }

    @Test
    void testLabelsArray() {
        int[][] table = labels.getTableOfNumbers(5);
        assertEquals(6, table[0][4]);
        assertEquals(5, table[3][0]);
        assertEquals(4, table[1][1]);
        assertEquals(3, table[1][0]);
        assertEquals(10, table[4][4]);
    }
}

