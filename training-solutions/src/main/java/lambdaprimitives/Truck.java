package lambdaprimitives;

import java.util.IntSummaryStatistics;
import java.util.List;

public class Truck {

    private List<Cargo> thingsToLoad;

    public Truck(List<Cargo> thingsToLoad) {
        this.thingsToLoad = thingsToLoad;
    }

    public double getShortestLength() {
        return thingsToLoad.stream()
                .mapToDouble(Cargo::getLength)
                .min().orElse(0.0);
    }

    public int getTotalWeight() {
        return thingsToLoad.stream()
                .mapToInt(Cargo::getWeight)
                .sum();
    }

    public double getAverageWeight() {
        return thingsToLoad.stream()
                .mapToInt(Cargo::getWeight)
                .average().orElseThrow(() -> new IllegalArgumentException("No cargo."));
    }

    public int getMaxWeight() {
        return thingsToLoad.stream()
                .mapToInt(Cargo::getWeight)
                .max().orElse(0);
    }

    public String getWeightStatistics() {
        IntSummaryStatistics statistics = thingsToLoad.stream()
                .mapToInt(Cargo::getWeight)
                .summaryStatistics();

        if (statistics.getCount() > 0) {
            return String.format("A rakományban található %d tétel, melyeknek összsúlya %d kg, közülük a legnehezebb " +
                            "%d kg, a legkönnyebb %d kg. A súlyuk átlagosan %.1f kg.",
                    statistics.getCount(), statistics.getSum(), statistics.getMax(), statistics.getMin(), statistics.getAverage());
        }
        return "No cargo.";
    }
}
