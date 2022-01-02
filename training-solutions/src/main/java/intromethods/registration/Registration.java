package intromethods.registration;

import java.time.LocalDate;
import java.util.Scanner;

public class Registration {

    public static String concatenateFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    public static LocalDate generateDate(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("***** Registration *****");
        System.out.println("Enter your first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter your year of birth:");
        int yearOfBirth = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your month of birth (with integer):");
        int monthOfBirth = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your day of birth:");
        int dayOfBirth = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your e-mail:");
        String email = scanner.nextLine();

        String fullName = concatenateFullName(firstName, lastName);
        LocalDate dateOfBirth = generateDate(yearOfBirth, monthOfBirth, dayOfBirth);

        Person person = new Person(fullName, dateOfBirth, email);

        System.out.println(person);
    }
}
