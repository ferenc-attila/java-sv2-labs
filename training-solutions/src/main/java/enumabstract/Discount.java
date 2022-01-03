package enumabstract;

public enum Discount {

    SPECIAL_OFFER {
        @Override
        public double getAmountToPay(int price, int pieces) {
            return price * 0.8 * pieces;
        }
    },

    BLACK_FRIDAY_OFFER {
        @Override
        public double getAmountToPay(int price, int pieces) {
            if (pieces < 3) {
                return price * 0.75 * pieces;
            } else {
                return price * 0.5 + price * 0.75 * (pieces - 1);
            }
        }
    };

    public abstract double getAmountToPay(int price, int pieces);
}
