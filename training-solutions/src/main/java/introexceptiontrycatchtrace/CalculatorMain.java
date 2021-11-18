package introexceptiontrycatchtrace;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first integer!");
        int firstNumber = 0;
        try {
            firstNumber = sc.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("Not a valid integer! The first number will be 0.");
            ime.printStackTrace();
        }
        sc.nextLine();

        System.out.println("Enter the second integer!");
        int secondNumber = 0;
        try {
            secondNumber = sc.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("Not a valid integer! The second number will be 0.");
            ime.printStackTrace();
        }
        sc.nextLine();

        Calculator calculator = new Calculator(firstNumber, secondNumber);

        System.out.println("Which operation do you want to use? ('+', '-', '/', '*') Enter an operator");
        String operator = sc.nextLine();

        try {
            switch (operator) {
                case "+":
                    System.out.println(calculator.addition());
                    break;
                case "-":
                    System.out.println(calculator.subtraction());
                    break;
                case "*":
                    System.out.println(calculator.multiplication());
                    break;
                case "/":
                    System.out.println(calculator.division());
                    break;
                default:
                    System.out.println("You entered an invalid operator!");
            }
        } catch (ArithmeticException ae) {
            System.out.println("Division by zero cannot be interpreted!");
            ae.printStackTrace();
        }
    }
}
