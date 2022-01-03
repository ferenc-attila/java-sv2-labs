package statemachine.typewriter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeWriterStateTest {

    @Test
    void TypeWriterStateTest() {

        TypeWriterState typeWriterState = TypeWriterState.CAPS_LOCK_ON;

        assertEquals(TypeWriterState.CAPS_LOCK_OFF, typeWriterState.nextState());
        typeWriterState = typeWriterState.nextState();
        assertEquals(TypeWriterState.CAPS_LOCK_ON, typeWriterState.nextState());
    }
}