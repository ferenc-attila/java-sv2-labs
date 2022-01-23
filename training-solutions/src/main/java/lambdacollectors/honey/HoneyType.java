package lambdacollectors.honey;

public enum HoneyType {

    MULTIFLORAL(1200), ACACIA(1800), LINDEN(1500);

    private final int price;

    HoneyType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
