package dynamictypes.publictransport;

public class Tram extends PublicVehicle {

    private int numberOfTramCars;

    public Tram(int lineNumber, double length, int numberOfTramCars) {
        super(lineNumber, length);
        this.numberOfTramCars = numberOfTramCars;
    }

    public int getNumberOfTramCars() {
        return numberOfTramCars;
    }
}
