package arrayofarrays;

public class Rectangle {

    public int[][] rectangularMatrix(int size) {
        int[][] rectangle = new int[size][size];
        for (int i = 0; i < size; i++) {
            rectangle[i] = new int[size];
            for (int j = 0; j < size; j++) {
                rectangle[i][j] = i;
            }
        }
        return rectangle;
    }

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle();
        ArrayOfArrays arrayOfArray = new ArrayOfArrays();

        arrayOfArray.printArrayOfArrays(rectangle.rectangularMatrix(10));
    }
}
