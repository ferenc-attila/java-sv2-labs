package aslist;

import java.util.Arrays;
import java.util.List;

public class Island {

    public static void main(String[] args) {

        System.out.print("My original list: ");
        List<String> elements = Arrays.asList("Lord of the Rings book", "axe", "hammock");
        System.out.println(elements);

        System.out.print("My modified list: ");
        elements.set(1, "hand saw");
        System.out.println(elements);
    }
}
