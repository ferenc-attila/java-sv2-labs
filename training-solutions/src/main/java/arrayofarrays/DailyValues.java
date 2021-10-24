package arrayofarrays;

public class DailyValues {

    int[][] getValues() {
        int[][] dailyValues = new int[12][];
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 0; i < 12; i++) {
            dailyValues[i] = new int[daysInMonths[i]];
        }
        return dailyValues;
    }

    public static void main(String[] args) {
        DailyValues dailyValues = new DailyValues();
        ArrayOfArrays arrayOfArray = new ArrayOfArrays();

        arrayOfArray.printArrayOfArrays(dailyValues.getValues());
    }
}
