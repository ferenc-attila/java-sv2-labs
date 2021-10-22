package arrays;

import java.util.Arrays;

public class ArraysMain {

    public static void main(String[] args) {

        int[] a1 = {3, 2, 1};
        int[] a2 = {3, 2, 1};

        int[][] b1 = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        int[][] b2 = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};

        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.deepToString(b1));

        System.out.println(Arrays.equals(a1,a2));
        System.out.println(Arrays.deepEquals(b1,b2));

        Arrays.sort(a1);
        System.out.println(Arrays.toString(a1));

        System.out.println(Arrays.toString(Arrays.copyOfRange(a1, 1,3)));
    }
}
