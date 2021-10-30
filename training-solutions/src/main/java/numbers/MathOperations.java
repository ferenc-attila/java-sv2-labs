package numbers;

import java.util.Scanner;

public class MathOperations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the result of the calculation task below:");
        System.out.println("((3.0 + 2) * 10 / 2 - 10) / (5 * 2)");
        double result = scanner.nextDouble();

        System.out.println(Math.abs(1.5 - result) < 0.0001 ? "The result is correct" : "Wrong answer. The correct result is 1.5");
    }
}
