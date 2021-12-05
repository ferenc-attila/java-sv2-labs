package inheritancemethods.plane;

public class PriorityPassenger extends Passenger {

    private final int percent;

    public PriorityPassenger(String name, int priceOfPlaneTicket, int percent) {
        super(name, priceOfPlaneTicket);
        this.percent = percent;
    }

    public int getPercent() {
        return percent;
    }

    @Override
    public int getPriceOfPlaneTicket() {
        return super.getPriceOfPlaneTicket() * (100 + percent) / 100;
    }
}
