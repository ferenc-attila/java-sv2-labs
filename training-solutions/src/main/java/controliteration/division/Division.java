package controliteration.division;

import java.util.Scanner;

public class Division {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Adjon meg egy pozitív egész számot! A program ennél kisebb számokat fog kiírni.");
        int bound = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Hánnyal osztható számokat szeretne kapni?");
        int divider = scanner.nextInt();
        scanner.nextLine();

        boolean first = true;
        for (int i = 1; i < bound; i++) {
            if (i % divider == 0) {
                if (first) {
                    first = false;
                    System.out.print(i);
                } else {
                    System.out.print(", " + i);
                }
            }
        }
        System.out.println();

        first = true;
        int count = 1;
        while (count < bound) {
            if (count % divider == 0) {
                if (first) {
                    first = false;
                    System.out.print(count);
                } else {
                    System.out.print(", " + count);
                }
            }
            count++;
        }
    }
}
