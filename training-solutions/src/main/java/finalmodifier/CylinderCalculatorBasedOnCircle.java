package finalmodifier;

public class CylinderCalculatorBasedOnCircle {

    CircleCalculator circleCalculator = new CircleCalculator();

    public double calculateVolume(double r, double h) {
        return (h * circleCalculator.calculateArea(r));
    }

    public double calculateSurface(double r, double h) {
        return ((h * circleCalculator.calculatePerimeter(r)) + 2 * (circleCalculator.calculateArea(r)));
    }
}
