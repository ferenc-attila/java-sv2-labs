package virtualmethod.vehicle;

public class FerryBoat extends Vehicle{

    private Car car;
    public static final int MAX_CARRY_WEIGHT = 1500;

    public FerryBoat(int vehicleWeight) {
        super(vehicleWeight);
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad() + car.getGrossLoad();
    }

    public boolean canCarry (Car car) {
        return car.getVehicleWeight() < MAX_CARRY_WEIGHT;
    }

    public boolean load (Car car) {
        if (canCarry(car)) {
            this.car = car;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "FerryBoat{car=" + car.toString() + "}";
    }
}
