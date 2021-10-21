package arrayofarrays;

public class ArrayOfArrays {

    public void printArrayOfArrays (int [][] a) {
        for (int[] array: a) {
            for (int number: array) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int [][] a = {{0, 1, 2}, {0, 1, 2}, {0, 1, 2,}};

        ArrayOfArrays arrayOfArrays = new ArrayOfArrays();

        arrayOfArrays.printArrayOfArrays(a);
    }
}
