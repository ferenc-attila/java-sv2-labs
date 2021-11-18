package introexceptiontrycatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstLetter {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList(null, "répa", "mogyoró", "", "káposzta", "krumpli", " "));

        for (String word : words) {
            try {
                word = word.trim();
                try {
                    System.out.println(word.charAt(0));
                } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
                    System.out.println("String contains only whitespaces, or empty!");
                    System.out.println(stringIndexOutOfBoundsException.getMessage());
                }
            } catch (NullPointerException npe) {
                System.out.println("Null string in the list");
                System.out.println(npe.getMessage());
            }
        }
    }
}
