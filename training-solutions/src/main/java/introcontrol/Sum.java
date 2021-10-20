package introcontrol;

import java.util.Scanner;

public class Sum {

    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

        System.out.println("Enter five numbers");
        double sum = 0;
        for (int i = 0; i<5; i++) {
            sum = sum + scanner.nextDouble();
            scanner.nextLine();
        }

        System.out.println("Sum of your numbers: " + sum);
    }
}
