package finalmodifier;

public class CylinderCalculator {

    public double calculateVolume(double r, double h) {
        return (h * r * r * CircleCalculator.PI);
    }

    public double calculateSurface(double r, double h) {
        return ((h * 2 * r * CircleCalculator.PI) + 2 * (r * r * CircleCalculator.PI));
    }
}
