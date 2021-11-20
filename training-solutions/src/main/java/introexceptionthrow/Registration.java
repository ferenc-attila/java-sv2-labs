package introexceptionthrow;

import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Validation validation = new Validation();
        boolean valid = true;

        System.out.println("Enter your name!");
        String name = scanner.nextLine();
        try {
            validation.validateName(name);
        } catch (IllegalArgumentException iaeName) {
            System.out.println(iaeName.getMessage());
            valid = false;
        }

        System.out.println("Enter your age");
        String ageString = scanner.nextLine();
        try {
            validation.validateAge(ageString);
        } catch (IllegalArgumentException iaeAge) {
            System.out.println(iaeAge.getMessage());
            valid = false;
        }
        StringBuilder registrationData = new StringBuilder("You entered the following data:\n");
        registrationData.append("Name: " + name + "\nAge: " + ageString);
        System.out.println(registrationData);

        if (valid) {
            System.out.println("The registration was successful!");
        } else {
            System.out.println("The registration was unsuccessful!");
        }
    }
}
