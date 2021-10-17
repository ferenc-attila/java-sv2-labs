package statements;

import java.util.Scanner;

public class TimeMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the hours of the first time:");
        int firstHours = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the minutes of the first time");
        int firstMinutes = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the seconds of the first time");
        int firstSeconds = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the hours of the second time:");
        int secondHours = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the minutes of the second time");
        int secondMinutes = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the seconds of the second time");
        int secondSeconds = scanner.nextInt();
        scanner.nextLine();

        Time firstTime = new Time(firstHours, firstMinutes, firstSeconds);
        Time secondTime = new Time(secondHours, secondMinutes, secondSeconds);

        
    }
}
