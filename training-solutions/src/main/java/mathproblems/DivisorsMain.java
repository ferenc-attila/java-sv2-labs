package mathproblems;

public class DivisorsMain {

    public static void main(String[] args) {

        Divisors divisors = new Divisors();
        divisors.getDivisors(4000);

        int[] numbers = {2, 5, 23, 56, -36, 45, 78, 14, -8, 4, 10};
        divisors.getRightNumbers(numbers);
    }
}
