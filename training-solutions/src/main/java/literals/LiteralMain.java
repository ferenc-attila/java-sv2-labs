package literals;

public class LiteralMain {

    public static void main(String[] args) {

//        System.out.println(0b1111_1111);
//        System.out.println(0377);
//        System.out.println(0xff);
//
//        long l = 100_000_000_000L;
//
//        System.out.println(-12e4);
//
//        float f =1.0F;
//
//        System.out.println("Hello \n\"World\"!");

        System.out.println("1" + "2");
        System.out.println("1" + 2);
        System.out.println(1 + "2");
        Integer i = 1;
        Integer j = 2;
        System.out.println(i.toString() + j.toString());
        String k = String.valueOf(i) + String.valueOf(j);
        System.out.println(k);

        double quotient = 3 / 4;
        System.out.println(quotient);

        quotient = 3.0 / 4.0;
        System.out.println(quotient);
        quotient = 3F / 4F;
        System.out.println(quotient);

        long big = 3_244_444_444L;
        System.out.println(big);

        String word = "title".toUpperCase();
        System.out.println(word);

        Integer binaryNumberA = 1;
        Integer binaryNumberB = 2;
        System.out.println(Integer.toBinaryString(binaryNumberA));
        System.out.println(Integer.toBinaryString(binaryNumberB));
    }
}
