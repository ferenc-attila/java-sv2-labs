package lambdaprimitives;

import java.util.IntSummaryStatistics;
import java.util.List;

public class SportGadgetStore {

    private List<Product> products;

    public SportGadgetStore(List<Product> products) {
        this.products = products;
    }

    public int getNumberOfProducts() {
        return products.stream()
                .mapToInt(Product::getAmount)
                .sum();
    }

    public double getAveragePrice() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .average().orElse(0);
    }

    public String getExpensiveProductStatistics(double minPrice) {
        IntSummaryStatistics statistics = products.stream()
                .filter(p -> p.getPrice() > minPrice)
                .mapToInt(Product::getAmount)
                .summaryStatistics();
        if (statistics.getCount() > 0) {
            return String.format("Összesen %d féle termék, amelyekből minimum %d db, maximum %d db, összesen %d db van.",
                    statistics.getCount(), statistics.getMin(), statistics.getMax(), statistics.getSum());
        }
        return "Nincs ilyen termék.";
    }
}
