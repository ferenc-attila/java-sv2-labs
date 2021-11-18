package introexceptionthrowjunit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentTest {

    Student student = new Student();

    @Test
    void addLegalNoteTest() {
        student.addNote(1);
        student.addNote(5);
        assertEquals(1, student.getNotes().get(0));
        assertEquals(5, student.getNotes().get(1));
    }

    @Test
    void addIllegalNoteTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> student.addNote(6));
        assertEquals("Note must be between 1 and 5!", iae.getMessage());
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> student.addNote(0));
        assertEquals("Note must be between 1 and 5!", exception.getMessage());
    }
}