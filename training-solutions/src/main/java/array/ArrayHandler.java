package array;

public class ArrayHandler {

    public void addIndexToNumber(int[] source) {
        for (int i = 0; i < source.length; i++) {
            source[i] = source[i] + i;
        }
    }

    public void concatenateIndexToWord(String[] source) {
        for (int i = 0; i < source.length; i++) {
            source[i] = i + source[i];
        }
    }

    public static void main(String[] args) {

        ArrayHandler handler = new ArrayHandler();

        int[] arrayOfIntegers = {1, 2, 3, 4, 5, 6};
        String[] arrayOfStrings = {"testers", "to", "try", "concatenate", "to", "elements", "of", "an", "array"};

        handler.addIndexToNumber(arrayOfIntegers);
        handler.concatenateIndexToWord(arrayOfStrings);

        for (int item : arrayOfIntegers) {
            System.out.println(item);
        }
        for (int item : arrayOfIntegers) {
            System.out.print(item + ", ");
        }
        System.out.println();

        for (String item : arrayOfStrings) {
            System.out.println(item);
        }
        for (String item : arrayOfStrings) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }
}
