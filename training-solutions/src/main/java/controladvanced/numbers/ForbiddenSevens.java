package controladvanced.numbers;

import java.util.Scanner;

public class ForbiddenSevens {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Tiltott hetesek ***");
        System.out.println("Adj meg egy pozitív egész számot!");
        int number = scanner.nextInt();
        scanner.nextLine();


        String print;
//        for (int i = number; i >= number; i++) {
//            if (i % 7 == 0) {
//                print = "X";
//                System.out.println(print);
//                continue;
//            } else {
//                print = Integer.toString(i);
//            }
//            if (print.contains("7")) {
//                break;
//            }
//            System.out.println(i);
//        }

        boolean isContainsSeven = false;

        while (!isContainsSeven) {
            if (number % 7 == 0) {
                print = "X";
            } else {
                print = Integer.toString(number);
            }
            isContainsSeven = print.contains("7");
            if (isContainsSeven) {
                continue; // A break ugyanúgy helyes működést eredményez, de így a SonarLint is látja, hogy nem lesz végtelen a ciklus.
            }
            System.out.println(print);
            number++;
        }
    }
}
