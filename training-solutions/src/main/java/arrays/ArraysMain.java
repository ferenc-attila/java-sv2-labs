package arrays;

import java.util.Arrays;

public class ArraysMain {

    public static String numberOfDaysAsString() {
        int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return Arrays.toString(numberOfDays);
    }

    public static String multiplicationTableAsString(int size) {
        int[][] multiplicationTable = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                multiplicationTable[i][j] = i * j;
            }
        }
        return Arrays.deepToString(multiplicationTable);
    }

    public static boolean sameTempValues(double[] day, double[] anotherDay) {
        return Arrays.equals(day, anotherDay);
    }

    public static int min(int a, int b) {
        int minimumInteger;
        if (a > b) {
            minimumInteger = b;
        } else {
            minimumInteger = a;
        }
        return minimumInteger;
    }

    public static boolean sameTempValuesDaylight(double[] day, double[] anotherDay) {
        int dayLength = day.length;
        int anotherDayLength = anotherDay.length;
        int minLength = min(dayLength, anotherDayLength);
        double[] reducedDay = Arrays.copyOfRange(day, 0, minLength);
        double[] reducedAnotherDay = Arrays.copyOfRange(anotherDay, 0, minLength);
        return Arrays.equals(reducedDay, reducedAnotherDay);
    }

    public static boolean wonLottery(int[] betNumbers, int[] winningNumbers) {
        int[] copyOfBetNumbers = Arrays.copyOf(betNumbers, betNumbers.length);
        int[] copyOfWinningNumbers = Arrays.copyOf(winningNumbers, winningNumbers.length);
        Arrays.sort(copyOfBetNumbers);
        Arrays.sort(copyOfWinningNumbers);
        return Arrays.equals(copyOfBetNumbers, copyOfWinningNumbers);
    }

    public static void main(String[] args) {

//        int[] a1 = {3, 2, 1};
//        int[] a2 = {3, 2, 1};
//
//        int[][] b1 = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
//        int[][] b2 = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
//
//        System.out.println(Arrays.toString(a1));
//        System.out.println(Arrays.deepToString(b1));
//
//        System.out.println(Arrays.equals(a1, a2));
//        System.out.println(Arrays.deepEquals(b1, b2));
//
//        Arrays.sort(a1);
//        System.out.println(Arrays.toString(a1));
//
//        System.out.println(Arrays.toString(Arrays.copyOfRange(a1, 1, 3)));

        ArraysMain arraysMain = new ArraysMain();

        System.out.println(arraysMain.numberOfDaysAsString());

        System.out.println(ArraysMain.multiplicationTableAsString(10));

        double[] day = {9.4, 8.3, 7.4, 7.1, 5.1, 5.8, 6.3, 7.5, 9.4, 11.0, 12.1, 14.5, 10.7, 9.4, 8.3, 7.4, 7.1, 5.1, 5.8, 6.3, 7.5, 9.4, 11.0, 12.1};
        double[] anotherDay = {9.4, 8.3, 7.4, 7.1, 5.1, 5.8, 6.3, 7.5, 9.4, 11.0, 12.1, 14.5, 10.7, 9.4, 8.3, 7.4, 7.1, 5.1, 5.8, 6.3, 7.5, 9.4, 11.0, 12.1, 14.5, 12.1};

        System.out.println(ArraysMain.sameTempValues(day, anotherDay));

        System.out.println((ArraysMain.sameTempValuesDaylight(day, anotherDay)));

        int[] betNumbers = {42, 37, 58, 89, 5};
        int[] winningNumbers = {37, 5, 58, 42, 89};

        System.out.println(Arrays.toString(betNumbers));
        System.out.println(Arrays.toString(winningNumbers));
        System.out.println(ArraysMain.wonLottery(betNumbers, winningNumbers));
        System.out.println(Arrays.toString(betNumbers));
        System.out.println(Arrays.toString(winningNumbers));
    }
}
