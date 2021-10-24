package introcontrol;

import java.util.Scanner;

public class Qualifier {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number:");
        double number = scanner.nextDouble();
        scanner.nextLine();

        if (number > 100.0) {
            System.out.println("The number is greater then 100.");
        } else {
            System.out.println("The number is equal to or less than 100.");
        }
    }
}
