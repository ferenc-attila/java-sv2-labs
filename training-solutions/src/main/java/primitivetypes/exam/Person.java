package primitivetypes.exam;

import java.time.LocalDate;

public class Person {

    String name;
    LocalDate dateOfBirth;
    int postalCode;
    double averageOfGrades;

    public Person(String name, LocalDate dateOfBirth, int postalCode, double averageOfGrades) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.postalCode = postalCode;
        this.averageOfGrades = averageOfGrades;
    }

    public String toString() {
        return "name: " + name + "\n" +
                "birth: " + dateOfBirth + "\n" +
                "Postal Code: " + postalCode + ";\n" +
                "Avg. of grades: " + averageOfGrades + ";\n";
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public double getAverageOfGrades() {
        return averageOfGrades;
    }
}
