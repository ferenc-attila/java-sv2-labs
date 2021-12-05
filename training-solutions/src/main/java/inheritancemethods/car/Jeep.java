package inheritancemethods.car;

public class Jeep extends Car {

    private double extraCapacity;
    private double extraFuel;

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        if (extraFuel > extraCapacity) {
            throw new IllegalArgumentException("Auxiliary capacity is less than fuel!");
        }
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    @Override
    public void modifyFuelAmount(double fuel) {
        super.modifyFuelAmount(fuel);
    }

    @Override
    public void drive(int km) {
        if (!isEnoughFuelJeep(km)) {
            throw new IllegalArgumentException("Not enough fuel available!");
        }
        double amount = km * (getFuelRate() / 100);
        extraFuel -= amount;
        if (extraFuel < 0) {
            modifyFuelAmount(extraFuel);
            extraFuel = 0;
        }
    }

    @Override
    public double calculateRefillAmount() {
        return super.calculateRefillAmount() + (this.extraCapacity - this.extraFuel);
    }

    @Override
    public double getFuelRate() {
        return super.getFuelRate();
    }

    @Override
    public double getFuel() {
        return super.getFuel();
    }

    @Override
    public double getTankCapacity() {
        return super.getTankCapacity();
    }

    public double getExtraCapacity() {
        return extraCapacity;
    }

    public double getExtraFuel() {
        return extraFuel;
    }

    private boolean isEnoughFuelJeep(int km) {
        return (getFuel() + getExtraFuel() - km * (getFuelRate() / 100) >= 0.0);
    }
}
