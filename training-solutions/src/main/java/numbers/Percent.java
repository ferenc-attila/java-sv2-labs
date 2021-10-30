package numbers;

public class Percent {

    public double getValue(int a, int b) {
        return a * (b / 100.0);
    }

    public double getBase(int a, int b) {
        return a / (b / 100.0);
    }

    public double getPercent(int a, int b) {
        return 100.0 * b / a;
    }
}
