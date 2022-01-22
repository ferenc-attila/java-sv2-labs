package lambdaintro;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class UsedCars {

    private List<Car> carsForSell;

    public UsedCars(List<Car> carsForSell) {
        this.carsForSell = carsForSell;
    }

    public List<Car> listCarsByPrice() {
        List<Car> sortedByPrice = new ArrayList<>(carsForSell);
        sortedByPrice.sort((car1, car2) ->
                Integer.valueOf(car1.getPrice()).compareTo(car2.getPrice()));
        return sortedByPrice;
    }

    public List<Car> listCarsByLengthDesc() {
        List<Car> sortedByLengthDesc = new ArrayList<>(carsForSell);
        sortedByLengthDesc.sort((car1, car2) ->
                Double.valueOf(car2.getLength()).compareTo(car1.getLength()));
        return sortedByLengthDesc;
    }

    public List<Car> listCarsOneBrandByType(String brand) {
        List<Car> carsOfOneBrand = new ArrayList<>(this.findCars(car -> car.getBrand().equals(brand)));
        carsOfOneBrand.sort((car1, car2) ->
                car1.getType().compareTo(car2.getType()));
        return carsOfOneBrand;
    }

    private List<Car> findCars(Predicate<Car> condition) {
        List<Car> foundedCars = new ArrayList<>();
        for (Car actual : carsForSell) {
            if (condition.test(actual)) {
                foundedCars.add(actual);
            }
        }
        return foundedCars;
    }
}
