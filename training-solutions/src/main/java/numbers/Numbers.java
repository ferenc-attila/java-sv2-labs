package numbers;

public class Numbers {

    public static void main(String[] args) {

        System.out.println(1 / 2);
        System.out.println(1 / 2.0);
        System.out.println(1 / 2D);
        System.out.println(1d / 2);
        System.out.println((double) 1 / 2);

        System.out.println(0.1 * 3 == 0.3);
        System.out.println(0.1 * 3 - 0.3);
        System.out.println(Math.abs(0.1 * 3 - 0.3) < 1e-15);
    }
}
