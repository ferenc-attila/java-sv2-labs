package aslist;

import java.util.Arrays;
import java.util.List;

public class Island {

    public static void main(String[] args) {

        System.out.print("My original list: ");
        List<String> importantThings = Arrays.asList("Lord of the Rings book", "axe", "hammock");
        System.out.println(importantThings);

        System.out.print("My modified list: ");
        importantThings.set(1, "hand saw");
        System.out.println(importantThings);
    }
}
