package math;

import java.util.Random;

public class MathMain {

    public static void main(String[] args) {
        System.out.println(Math.PI);
        System.out.println(Math.E);
        System.out.println(Math.round(10.5));
        System.out.println(Math.abs(-10));
        System.out.println(Math.max(10, -10));

        System.out.println(new Random(13).nextInt(100));
    }
}
