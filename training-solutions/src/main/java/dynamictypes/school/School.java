package dynamictypes.school;

public class School {

    String name;
    int numberOfYears;

    public School(String name, int numberOfYears) {
        this.name = name;
        this.numberOfYears = numberOfYears;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nNumber of years: " + numberOfYears;
    }
}
