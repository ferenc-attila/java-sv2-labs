package introexceptionfinally;

import java.util.Scanner;

public class Numbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number;
        do {
            System.out.println("Enter an integer!");
            String numberString = scanner.nextLine();
            try {
                number = Integer.parseInt(numberString);
            } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException("Not a number!", nfe);
            } finally {
                System.out.println("End of round.");
            }
        } while (number % 2 == 1);
    }
}
