package statemachine.seatheater;

public enum SeatHeaterState {

    OFF {
        public SeatHeaterState nextSeatHeaterState() {
            return SeatHeaterState.MAXIMUM;
        }
    },

    MAXIMUM {
        public SeatHeaterState nextSeatHeaterState() {
            return SeatHeaterState.MEDIUM;
        }
    },

    MEDIUM {
        public SeatHeaterState nextSeatHeaterState() {
            return SeatHeaterState.MINIMUM;
        }
    },

    MINIMUM {
        public SeatHeaterState nextSeatHeaterState() {
            return SeatHeaterState.OFF;
        }
    };

    abstract SeatHeaterState nextSeatHeaterState();
}
