package collectionsequalshash;

import java.util.Objects;

public class Product {

    private String name;
    private String registrationNumber;

    public Product(String name, String registrationNumber) {
        this.name = name;
        this.registrationNumber = registrationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return registrationNumber.equals(product.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber);
    }

    public String getName() {
        return name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
