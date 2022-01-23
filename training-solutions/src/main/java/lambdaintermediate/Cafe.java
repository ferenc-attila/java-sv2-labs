package lambdaintermediate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Cafe {

    private List<CoffeeOrder> orders;

    public Cafe(List<CoffeeOrder> orders) {
        this.orders = orders;
    }

    public void addOrder(CoffeeOrder order) {
        orders.add(order);
    }

    public Integer getTotalIncome() {
        Stream<List<Coffee>> coffees = createCoffeeStream(orders);
        return coffees.flatMap(Collection::stream)
                .map(Coffee::getPrice)
                .reduce(0,
                        Integer::sum,
                        Integer::sum);
    }

    public Integer getTotalIncome(LocalDate date) {
        List<CoffeeOrder> ordersOfADay = orders.stream()
                .filter(o -> o.getDateTime().toLocalDate().equals(date))
                .toList();
        Stream<List<Coffee>> coffees = createCoffeeStream(ordersOfADay);
        return coffees
                .flatMap(Collection::stream)
                .map(Coffee::getPrice)
                .reduce(0,
                        Integer::sum,
                        Integer::sum);
    }

    public long getNumberOfCoffee(CoffeeType type) {
        Stream<List<Coffee>> coffees = createCoffeeStream(orders);
        return coffees.flatMap(Collection::stream)
                .filter(c -> c.getType() == type)
                .count();
    }

    public List<CoffeeOrder> getOrdersAfter(LocalDateTime from) {
        return orders.stream()
                .filter(o -> o.getDateTime().isAfter(from))
                .toList();
    }

    public List<CoffeeOrder> getFirstFiveOrder(LocalDate date) {
        return orders.stream()
                .filter(o -> o.getDateTime().toLocalDate().equals(date))
                .sorted(Comparator.comparing(CoffeeOrder::getDateTime))
                .limit(5)
                .toList();
    }

    private Stream<List<Coffee>> createCoffeeStream(List<CoffeeOrder> coffeeOrders) {
        return coffeeOrders.stream().map(CoffeeOrder::getCoffees);
    }
}
