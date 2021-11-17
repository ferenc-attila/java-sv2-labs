package introexceptiontrycatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstLetter {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("répa", "mogyoró", "káposzta", "krumpli", "", null));

        for (String word : words) {
            try {
                System.out.println(word.charAt(0));
            } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
                System.out.println("Empty string in the list!");
                System.out.println(stringIndexOutOfBoundsException.getMessage());
            } catch (NullPointerException npe) {
                System.out.println("Null string in the list");
                System.out.println(npe.getMessage());
            }
        }
    }
}
