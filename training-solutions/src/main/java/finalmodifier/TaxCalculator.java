package finalmodifier;

public class TaxCalculator {

    public static final double TAX = 27.;

    public double tax (double price) {
        return price * (TAX / 100);
    }

    public double priceWithTax (double price) {
        return price + tax(price);
    }
}
