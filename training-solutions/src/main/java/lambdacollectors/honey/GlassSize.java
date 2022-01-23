package lambdacollectors.honey;

public enum GlassSize {

    BIG(1.0), SMALL(0.5), TASTER_SIZE(0.05);

    private final double capacity;

    GlassSize(double capacity) {
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }
}
