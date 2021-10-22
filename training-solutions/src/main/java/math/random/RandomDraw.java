package math.random;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomDraw {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("John", "Jack", "Peter", "Jill", "James", "Jane", "Sylvia", "Alex", "Bill", "Joe");

        int zeroToFive = new Random().nextInt(5);
        int fiveToTen = new Random().nextInt(5) + 5;

        System.out.println(names.get(zeroToFive));
        System.out.println(names.get(fiveToTen));
    }
}
