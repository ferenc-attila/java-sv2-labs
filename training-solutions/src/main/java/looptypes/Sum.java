package looptypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum {

    public static void printSums(int[] numbers) {
        List<Integer> sums = new ArrayList<>(Arrays.asList());
        for (int i = 0; i < numbers.length - 1; i++) {
            sums.add(numbers[i] + numbers[i + 1]);
        }
        System.out.println(sums);
    }
}
