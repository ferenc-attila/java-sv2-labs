package conversions;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Digits {

    List<Integer> digits = new ArrayList<>();

    public void addDigitsToList(String text) {
        char[] characters = text.toCharArray();
        for (char character : characters) {
            if (Character.isDigit(character)) {
                char[] digitChar = {character};
                String digitString = new String(digitChar);
                digits.add(parseInt(digitString));
            }
        }
    }

    public List<Integer> getDigits() {
        return digits;
    }
}
