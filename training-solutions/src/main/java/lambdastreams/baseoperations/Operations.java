package lambdastreams.baseoperations;

import java.util.*;

public class Operations {

    private List<Integer> numbers;

    public Operations(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Optional<Integer> min() {
        return numbers.stream().min(Comparator.naturalOrder());
    }

    public Integer sum() {
        return numbers.stream().reduce(0,
                (integer, integer2) -> integer += integer2,
                (integer, integer2) -> integer += integer2);
    }

    public boolean isAllPositive() {
        return numbers.stream().allMatch(i -> i > 0);
    }

    public Set<Integer> getDistinctElements() {
        return numbers.stream().collect(HashSet::new,
                Set::add, Set::addAll);
    }
}
