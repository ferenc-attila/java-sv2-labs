package sorting.webshop;

import java.time.LocalDateTime;

public class Product {

    private String name;
    private int price;
    private LocalDateTime from;

    public Product(String name, int price, LocalDateTime from) {
        this.name = name;
        this.price = price;
        this.from = from;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public LocalDateTime getFrom() {
        return from;
    }
}
