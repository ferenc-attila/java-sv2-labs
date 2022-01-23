package lambdacollectors.christmastree;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChristmasTreeFair {

    private List<ChristmasTree> trees;

    public ChristmasTreeFair(List<ChristmasTree> trees) {
        this.trees = trees;
    }

    public Map<PineTreeType, Long> getCountByType() {
        return trees.stream()
                .collect(Collectors.groupingBy(
                        ChristmasTree::getType,
                        Collectors.counting()
                ));
    }

    public double getMaxHeightByType(PineTreeType type) {
        return trees.stream()
                .filter(christmasTree -> christmasTree.getType() == type)
                .collect(Collectors.mapping(ChristmasTree::getHeight,
                        Collectors.maxBy(Comparator.naturalOrder())))
                .orElse(0.0);
    }

    public double getAveragePrice() {
        if (trees.isEmpty()) {
            return 0.0;
        }
        return trees.stream()
                .collect(Collectors.averagingDouble(c -> c.getType().getPricePerMeter()));
    }
}
