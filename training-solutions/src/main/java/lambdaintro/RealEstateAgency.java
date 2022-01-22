package lambdaintro;

import java.util.List;
import java.util.function.Predicate;

public class RealEstateAgency {

    private List<Flat> flatsForSell;

    public RealEstateAgency(List<Flat> flatsForSell) {
        this.flatsForSell = flatsForSell;
    }

    public Flat findFirstCheaperFlat(int maxPrice) {
        return findFirst(flat -> flat.getPrice() < maxPrice);
    }

    public Flat findFirstGreaterFlat(double minArea) {
        return findFirst(flat -> flat.getArea() > minArea);
    }

    public Flat findFirstFlatInSameTown(String town) {
        return findFirst(flat -> flat.getAddress().contains(town));
    }

    private Flat findFirst(Predicate<Flat> condition) {
        for (Flat actual : flatsForSell) {
            if (condition.test(actual)) {
                return actual;
            }
        }
        throw new IllegalArgumentException("No such flat.");
    }
}
