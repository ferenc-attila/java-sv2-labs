package methodstructure.bmi;

public class BodyMass {

    public static final double UNDERWEIGHT_MAX_BMI = 18.5;
    public static final double OVERWEIGHT_MIN_BMI = 25;

    private double weight;
    private double height;

    public BodyMass(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getBodyMassIndex() {
        return (this.weight / Math.pow(this.height, 2));
    }

    public BmiCategory getBody() {
        if (getBodyMassIndex() < UNDERWEIGHT_MAX_BMI) {
            return BmiCategory.UNDERWEIGHT;
        } else if (getBodyMassIndex() > OVERWEIGHT_MIN_BMI) {
            return BmiCategory.OVERWEIGHT;
        } else {
            return BmiCategory.NORMAL;
        }
    }

    public boolean isThinnerThan(BodyMass other) {
        return this.getBodyMassIndex() < other.getBodyMassIndex();
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }
}
