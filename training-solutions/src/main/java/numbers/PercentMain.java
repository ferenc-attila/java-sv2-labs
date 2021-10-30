package numbers;

import java.util.Scanner;

public class PercentMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Percent percent = new Percent();

        System.out.println("Enter the first number: ");
        int a = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the second number: ");
        int b = scanner.nextInt();
        scanner.nextLine();

        System.out.println(b + "% of " + a + " are " + percent.getValue(a, b));
        System.out.println(a + " are the " + b + "% of " + percent.getBase(a, b));
        System.out.println(b + " are the " + percent.getPercent(a, b) + "% of " + a);
    }
}
