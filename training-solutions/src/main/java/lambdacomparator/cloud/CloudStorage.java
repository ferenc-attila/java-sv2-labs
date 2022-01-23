package lambdacomparator.cloud;

import java.util.Objects;

public class CloudStorage implements Comparable<CloudStorage> {

    private static final int STANDARD_SIZE = 1000;
    private static final int STANDARD_PERIOD = 12;

    private String provider;
    private int space;
    private PayPeriod period;
    private double price;

    public CloudStorage(String provider, int space, PayPeriod period, double price) {
        this.provider = provider;
        this.space = space;
        this.period = period;
        this.price = price;
    }

    public CloudStorage(String provider, int space) {
        this.provider = provider;
        this.space = space;
    }

    @Override
    public int compareTo(CloudStorage o) {
        double currentValue = this.period != null ? this.price / this.period.getLength() / this.space * STANDARD_PERIOD * STANDARD_SIZE : 0;
        double anotherValue = o.period != null ? o.price / o.period.getLength() / o.space * STANDARD_PERIOD * STANDARD_SIZE : 0;
        return Double.compare(currentValue, anotherValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CloudStorage that = (CloudStorage) o;
        return space == that.space && Double.compare(that.price, price) == 0 && period == that.period;
    }

    @Override
    public int hashCode() {
        return Objects.hash(space, period, price);
    }

    public String getProvider() {
        return provider;
    }

    public int getSpace() {
        return space;
    }

    public PayPeriod getPeriod() {
        return period;
    }

    public double getPrice() {
        return price;
    }
}
