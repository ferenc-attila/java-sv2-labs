package algorithmssum.school;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SchoolTest {

    School school = new School();

    @Test
    void getNumberOfStudentsValidListTest() {
        List<Integer> headcounts = Arrays.asList(31, 27, 19, 25, 42, 25, 32);
        assertEquals(201, school.getNumberOfStudents(headcounts));
    }

    @Test
    void getNumberOfStudentsListWithNullTest() {
        List<Integer> headcounts = Arrays.asList(31, 27, 19, 25, 42, null, 25, 32);
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> school.getNumberOfStudents(headcounts));
        assertEquals("There is at least one 'null' value in the list!", iae.getMessage());
    }
}