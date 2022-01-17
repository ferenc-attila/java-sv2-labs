package sorting;

import java.util.ArrayList;
import java.util.List;

public class CarDealer {

    private List<Car> carsForSell = new ArrayList<>();

    public void addCar(Car car) {
        carsForSell.add(car);
    }

    public List<Car> getCarsOrderedByYearOfConstruction() {
        List<Car> sortedByConstruction = new ArrayList<>(carsForSell);
        sortedByConstruction.sort(new CarConstructionComparator());
        return sortedByConstruction;
    }

    public List<Car> getCarsOrderedByPrice() {
        List<Car> sortedByPrice = new ArrayList<>(carsForSell);
        sortedByPrice.sort(new CarPriceComparator());
        return sortedByPrice;
    }
}
