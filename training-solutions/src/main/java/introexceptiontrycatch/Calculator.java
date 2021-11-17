package introexceptiontrycatch;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer");
        int firstNumber = scanner.nextInt();
        System.out.println("Enter another integer");
        int secondNumber = scanner.nextInt();
        System.out.println("Which operation do you want to use? ('+', '-', '/', '*') Enter an operator");
        String operator = scanner.nextLine();

        switch (operator) {
            case "+":
                System.out.println(firstNumber + secondNumber);
                break;
            case "-":
                System.out.println(firstNumber - secondNumber);
                break;
            case "*":
                System.out.println(firstNumber * secondNumber);
                break;
            case "/":
                System.out.println(firstNumber / secondNumber);
                break;
            default:
                System.out.println("You entered an invalid operator!");
        }

    }
}
