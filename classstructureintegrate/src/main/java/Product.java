public class Product {

    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int increasePrice (int increaseAmount) {
        this.price = price + increaseAmount;
        return price;
    }

    public int decreasePrice (int decreaseAmount) {
        this.price = price - decreaseAmount;
        return price;
    }
}
