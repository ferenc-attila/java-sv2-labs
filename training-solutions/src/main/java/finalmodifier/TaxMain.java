package finalmodifier;

public class TaxMain {

    public static void main(String[] args) {

        TaxCalculator taxCalculator = new TaxCalculator();
        double price = 1000.;

        System.out.println(taxCalculator.tax(price));
        System.out.println(taxCalculator.priceWithTax(price));
    }
}
