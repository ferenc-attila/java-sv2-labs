package arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListMain {

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();

        l.add("one");
        l.add("two");
        l.add("three");

        String s = l.toString();

        System.out.println(s);
        System.out.println(l);

        System.out.println(l.get(1));
        l.add("four");

        l.remove(0);
        System.out.println(l);

        System.out.println(l.size());

        System.out.println(l.contains("one"));
        System.out.println(l.contains("two"));

        System.out.println(l.indexOf("two"));
        System.out.println(l.indexOf("four"));
        System.out.println(l.indexOf("one"));

        l.clear();
        System.out.println(l);

        List<Integer> i = Arrays.asList(1, 2, 3);

        for (int j = 0; j < i.size(); j++) {
            System.out.println(i.get(j));
        }

        for (int j: i) {
            System.out.println(j);
        }


    }
}
