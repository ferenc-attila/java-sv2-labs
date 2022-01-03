package enumabstract;

public enum OrderState implements Deletable{

    NEW {
        public boolean canDelete() {
            return true;
        }
    },

    CONFIRMED {
        public boolean canDelete() {
            return true;
        }
    },

    PREPARED {
        public boolean canDelete() {
            return true;
        }
    },

    ONBOARD {
        public boolean canDelete() {
            return false;
        }
    },

    DELIVERED {
        public boolean canDelete() {
            return false;
        }
    },

    RETURNED {
        public boolean canDelete() {
            return false;
        }
    },

    DELETED {
        public boolean canDelete() {
            return false;
        }
    }
}
