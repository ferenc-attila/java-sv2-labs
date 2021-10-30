package mathproblems;

public class Divisors {

    public void getDivisors(int number) {
        for (int i = 1; i <= number; i++) {
            if ((number % i) == 0) {
                System.out.println("The divisor of " + number + ": " + i);
            }
        }
    }

    public void getRightNumbers (int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] % i == 0) {
                System.out.print(numbers[i] + " ");
            }
        }
        System.out.println();
    }
}
