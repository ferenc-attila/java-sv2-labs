package aslist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sequence {

    public static void main(String[] args) {

        List<Integer> elements = new ArrayList<>(Arrays.asList(1, 2));
        int numberOfNewElements = 5;
        for (int i = 2; i - 2 < numberOfNewElements; i++) {
            elements.add(elements.get(i - 2) * elements.get(i - 1));
        }
        System.out.println(elements.size());
        System.out.println(elements);
    }
}
