package intromethods.registration;

import java.time.LocalDate;

public class Person {

    private String name;
    private LocalDate dateOfBirth;
    private String email;

    public Person(String name, LocalDate dateOfBirth, String email) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Details of the registered person:\n" +
                "name: " + name + ";\n" +
                "date of birth: " + dateOfBirth + ";\n" +
                "email: " + email + ";\n";
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }
}
