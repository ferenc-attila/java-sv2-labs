package introexceptiontrycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer");
        int firstNumber = 0;
        try {
            firstNumber = scanner.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Not an integer");
            System.out.println("First integer will be 0");
            System.out.println(inputMismatchException.getMessage());
        }
        scanner.nextLine();
        System.out.println("Enter another integer");
        int secondNumber = 0;
        try {
            secondNumber = scanner.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Not an integer");
            System.out.println("Second integer will be 0");
            System.out.println(inputMismatchException.getMessage());
        }

        scanner.nextLine();
        System.out.println("Which operation do you want to use? ('+', '-', '/', '*') Enter an operator");
        String operator = scanner.nextLine();

        try {
            switch (operator) {
                case "+":
                    System.out.println("Result: " + (firstNumber + secondNumber));
                    break;
                case "-":
                    System.out.println("Result: " + (firstNumber - secondNumber));
                    break;
                case "*":
                    System.out.println("Result: " + (firstNumber * secondNumber));
                    break;
                case "/":
                    System.out.println("Result: " + (firstNumber / secondNumber));
                    break;
                default:
                    System.out.println("You entered an invalid operator!");
            }
        } catch (ArithmeticException arithmeticException) {
            System.out.println("Division by zero cannot be interpreted!");
            System.out.println(arithmeticException.getMessage());
        }
    }
}
