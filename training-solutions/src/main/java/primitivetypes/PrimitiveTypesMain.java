package primitivetypes;

import java.util.ArrayList;
import java.util.List;

public class PrimitiveTypesMain {

    public static void main(String[] args) {

//        int i = 9;
//
//        Integer j = 9;
//
//        List<Integer> numbers = new ArrayList<>();
//
//        numbers.add(i);
//
//        System.out.println(Integer.toString(9,2));
//        System.out.println(Integer.toString(-9,2));
//        System.out.println(Integer.toBinaryString(-9));
//
//        int k = Integer.parseInt("9");
//
//        Integer l = new Integer("9");

        int a = 2;
        Integer b = 2;
        Integer c = a;
        Integer d = b;
        Integer e = Integer.valueOf(2);
        int f = Integer.valueOf(2);
        int g = Integer.valueOf(a);
        int h = Integer.valueOf(c);
        int i = Integer.parseInt("2");
        Integer j = Integer.parseInt("2");

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
        System.out.println(i);
        System.out.println(j);
    }
}
