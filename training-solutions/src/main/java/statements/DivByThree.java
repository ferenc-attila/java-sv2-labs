package statements;

import java.util.Scanner;

public class DivByThree {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer:");
        int number = scanner.nextInt();;
        scanner.nextLine();

        System.out.println((number % 3 == 0) ? "The number is divisible by three." :  "The number cannot be divided by three without remainder.");

    }

}
