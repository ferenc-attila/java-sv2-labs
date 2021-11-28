package methodstructure.pendrives;

public class Pendrive {

    private String name;
    private double capacity;
    private int price;

    public Pendrive(String name, double capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public void risePrice(int percent) {
        this.price = (int) (this.price * ((100d + percent) / 100));
    }

    public int comparePricePerCapacity(Pendrive other) {
        if (this.price / this.capacity > other.getPrice() / other.getCapacity()) {
            return 1;
        } else if (this.price / this.capacity < other.getPrice() / other.getCapacity()) {
            return -1;
        } else {
            return 0;
        }
    }

    public boolean isCheaperThan(Pendrive other) {
        return this.price < other.getPrice();
    }

    @Override
    public String toString() {
        return name + ": " + capacity + " Gb, " + price + " Ft";
    }

    public String getName() {
        return name;
    }

    public double getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }
}
