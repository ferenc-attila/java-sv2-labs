package inheritancemethods.car;

public class Car {

    private double fuelRate;
    private double fuel;
    private double tankCapacity;

    public Car(double fuelRate, double fuel, double tankCapacity) {
        this.fuelRate = fuelRate;
        if (fuel > tankCapacity) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.fuel = fuel;
        this.tankCapacity = tankCapacity;
    }

    public void modifyFuelAmount(double fuel) {
        if (fuel > this.tankCapacity - this.fuel) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        } else {
            this.fuel += fuel;
        }
    }

    public void drive(int km) {
        if (!isEnoughFuel(km)) {
            throw new IllegalArgumentException("Not enough fuel available!");
        } else {
            modifyFuelAmount(-1 * (km * (fuelRate / 100)));
        }
    }

    public double calculateRefillAmount() {
        return this.tankCapacity - this.fuel;
    }

    public double getFuelRate() {
        return fuelRate;
    }

    public double getFuel() {
        return fuel;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    private boolean isEnoughFuel(int km) {
        return (this.fuel - km * (fuelRate / 100) >= 0.0);
    }
}
