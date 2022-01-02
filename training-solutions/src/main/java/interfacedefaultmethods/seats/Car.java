package interfacedefaultmethods.seats;

public class Car implements Seat{

    private String brand;
    private int seats;

    public Car(String brand, int seats) {
        this.brand = brand;
        this.seats = seats;
    }

    @Override
    public int getNumberOfSeats() {
        return seats;
    }
}
