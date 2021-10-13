package classstructureconstructors;

public class Store {

    private String product;
    private int stock;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Store(String product) {
        this.product = product;
        this.stock = 0;
    }

    public void store(int amount) {
        this.stock = this.stock + amount;
    }

    public void dispatch(int amount) {
        this.stock = this.stock - amount;
    }
}
