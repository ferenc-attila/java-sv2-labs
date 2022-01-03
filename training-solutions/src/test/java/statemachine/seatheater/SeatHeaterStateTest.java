package statemachine.seatheater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeatHeaterStateTest {

    @Test
    void SeatHeaterTest() {

        SeatHeaterState seatHeaterState = SeatHeaterState.OFF;

        assertEquals(SeatHeaterState.MAXIMUM, seatHeaterState.nextSeatHeaterState());
        seatHeaterState = seatHeaterState.nextSeatHeaterState();
        assertEquals(SeatHeaterState.MEDIUM, seatHeaterState.nextSeatHeaterState());
        seatHeaterState = seatHeaterState.nextSeatHeaterState();
        assertEquals(SeatHeaterState.MINIMUM, seatHeaterState.nextSeatHeaterState());
        seatHeaterState = seatHeaterState.nextSeatHeaterState();
        assertEquals(SeatHeaterState.OFF, seatHeaterState.nextSeatHeaterState());
    }
}