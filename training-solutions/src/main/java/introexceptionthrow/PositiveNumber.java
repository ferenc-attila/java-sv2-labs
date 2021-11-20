package introexceptionthrow;

import java.util.Scanner;

public class PositiveNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a positive number!");
        String numberString = scanner.nextLine();
        char[] characters = numberString.toCharArray();
        for (char character : characters) {
            if (!Character.isDigit(character) || "0".equals(numberString)) {
                throw new IllegalArgumentException(numberString + " is not a positive number!");
            }
        }
    }
}
