package arrayofarrays;

public class Triangular {

    public int[][] triangularMatrix(int size) {

        int[][] triangular = new int[size][];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j<=i; j++) {
                triangular[i] = new int[j+1];
                for (int k = 0; k<=j; k++) {
                    triangular[j][k] = j;
                }
            }
        }
        return triangular;
    }

    public static void main(String[] args) {

        Triangular triangular = new Triangular();
        ArrayOfArrays arrayOfArray = new ArrayOfArrays();

        arrayOfArray.printArrayOfArrays(triangular.triangularMatrix(10));
    }

}
