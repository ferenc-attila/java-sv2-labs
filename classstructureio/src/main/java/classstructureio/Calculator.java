package classstructureio;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adj meg egy egész számot:");
        int firstNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Adj meg egy másik egész számot:");
        int secondNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println(firstNumber + " + " + secondNumber + " =");
        System.out.println(firstNumber + secondNumber);

    }
}
