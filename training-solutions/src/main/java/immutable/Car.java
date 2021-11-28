package immutable;

import java.time.LocalDate;

public class Car {

    private final String brand;
    private final String model;
    private final int yearOfProduction;

    public Car(String brand, String model, int yearOfProduction) {
        if (brand == null || brand.isEmpty()) {
            throw new IllegalArgumentException("Brand name cannot be empty!");
        } else {
            this.brand = brand;
        }
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Model name cannot be empty!");
        } else {
            this.model = model;
        }
        if (validateYearOfConstruction(yearOfProduction)) {
            this.yearOfProduction = yearOfProduction;
        } else {
            throw new IllegalArgumentException("Year of production cannot be in the future!");
        }
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    private boolean validateYearOfConstruction(int yearOfConstruction) {
        return yearOfConstruction <= LocalDate.now().getYear();
    }
}
