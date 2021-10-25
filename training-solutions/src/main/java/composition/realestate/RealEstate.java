package composition.realestate;

public class RealEstate {

    private String title;
    private double price;
    private Details details;

    public RealEstate(String title, double price, Details details) {
        this.title = title;
        this.price = price;
        this.details = details;
    }

    public String toString() {
        return "RealEstate: " + title + "\n" +
                "price: " + price + " million\n" +
                "Details:\n" + details.toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }
}
