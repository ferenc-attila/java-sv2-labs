package methodparam.sums;

public class Results {

    private double sumOfNegatives;
    private double sumOfPositives;

    public Results(double sumOfNegatives, double sumOfPositives) {
        this.sumOfNegatives = sumOfNegatives;
        this.sumOfPositives = sumOfPositives;
    }

    public double getSumOfNegatives() {
        return sumOfNegatives;
    }

    public double getSumOfPositives() {
        return sumOfPositives;
    }
}
