package typeconversion;

import java.util.Arrays;

public class ConversionMain {

    public static void main(String[] args) {

        Conversion conversion = new Conversion();

        double a = 1.6745;
        double b = -4.2356;
        double c = 0.00214;
        System.out.println(conversion.convertDoubleToDouble(a));
        System.out.println(conversion.convertDoubleToDouble(b));
        System.out.println(conversion.convertDoubleToDouble(c));

        int[] intArray = {5, -14, 6, 2, 125, 354, 9738, 3};
        System.out.println(Arrays.toString(conversion.convertIntArrayToByteArray(intArray)));

        System.out.println(conversion.getFirstDecimal(a));
        System.out.println(conversion.getFirstDecimal(b));
        System.out.println(conversion.getFirstDecimal(c));
    }
}
