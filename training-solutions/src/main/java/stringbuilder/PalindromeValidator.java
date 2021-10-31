package stringbuilder;

import java.util.Locale;

public class PalindromeValidator {

    public boolean isPalindrome (String word) {
        StringBuilder isPalindrome = new StringBuilder(word);
        return word.equalsIgnoreCase(isPalindrome.reverse().toString());
    }
}
