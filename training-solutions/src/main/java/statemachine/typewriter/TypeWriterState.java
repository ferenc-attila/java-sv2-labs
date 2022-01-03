package statemachine.typewriter;

public enum TypeWriterState {

    CAPS_LOCK_ON {
        public TypeWriterState nextState() {
            return TypeWriterState.CAPS_LOCK_OFF;
        }
    },

    CAPS_LOCK_OFF {
        public TypeWriterState nextState() {
            return TypeWriterState.CAPS_LOCK_ON;
        }
    };

    abstract TypeWriterState nextState();
}
