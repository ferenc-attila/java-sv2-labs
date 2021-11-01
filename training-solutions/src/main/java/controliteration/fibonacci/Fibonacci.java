package controliteration.fibonacci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {

        int nextElement;
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Fibonacci számsor ***");
        System.out.println();
        System.out.println("Hány elemét számoljam ki a sorozatnak?");
        int numberOfElements = scanner.nextInt();
        scanner.nextLine();

        List<Integer> fibonacciSequence = new ArrayList<>(Arrays.asList(0, 1));

//        for (int i = 2; i < numberOfElements; i++) {
//            nextElement = (fibonacciSequence.get(i - 1) + fibonacciSequence.get(i - 2));
//            fibonacciSequence.add(nextElement);
//        }
//
//        int count = 2;
//        do {
//            nextElement = fibonacciSequence.get(count - 1) + fibonacciSequence.get(count - 2);
//            fibonacciSequence.add(nextElement);
//            count++;
//        } while (count < numberOfElements);

        int count = 2;
        while (count < numberOfElements) {
            nextElement = fibonacciSequence.get(count - 1) + fibonacciSequence.get(count - 2);
            fibonacciSequence.add(nextElement);
            count++;
        }
        System.out.println(fibonacciSequence.toString());
    }
}
