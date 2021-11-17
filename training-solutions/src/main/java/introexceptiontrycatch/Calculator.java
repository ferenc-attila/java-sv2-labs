package introexceptiontrycatch;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer");
        int firstNUmber = scanner.nextInt();
        System.out.println("Enter another integer");
        int secondNumber = scanner.nextInt();
        System.out.println("Which operation do you want to use? ('+', '-', '/', '*') Enter an operator");
    }
}
