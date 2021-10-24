package array;

public class ArrayMain {

    public static void main(String[] args) {

        String arrayOfDays[] = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        System.out.println(arrayOfDays[1]);
        System.out.println(arrayOfDays.length);

        int exponentiation[] = new int[5];
        exponentiation[0] = 1;

        for (int i = 1; i < exponentiation.length; i++) {
            exponentiation[i] = exponentiation[i - 1] * 2;
        }

        for (int number : exponentiation) {
            System.out.print(number + " ");
        }
        System.out.println();

        boolean arrayOfBooleans[] = new boolean[6];
        arrayOfBooleans[0] = false;
        for (int i = 1; i < arrayOfBooleans.length; i++) {
            arrayOfBooleans[i] = !arrayOfBooleans[i - 1];
        }

        for (boolean item : arrayOfBooleans) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
