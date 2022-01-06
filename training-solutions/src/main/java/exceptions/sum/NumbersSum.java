package exceptions.sum;

public class NumbersSum {

    public int getSum(int[] numbers) {
        checkNull(numbers);
        int sum = 0;
        for (int actual : numbers) {
            sum += actual;
        }
        return sum;
    }

    public int getSum(String[] numbers) {
        checkNull(numbers);
        int[] parsed = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            parseStringToNumber(numbers, parsed, i);
        }
        return getSum(parsed);
    }

    private void parseStringToNumber(String[] numbers, int[] parsed, int i) {
        try {
            parsed[i] = Integer.parseInt(numbers[i]);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Unable to convert the \"" + numbers[i] + "\" string to number!");
        }
    }

    private void checkNull(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Numbers can't be null!");
        }
    }

    private void checkNull(String[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Numbers can't be null!");
        }
    }
}
