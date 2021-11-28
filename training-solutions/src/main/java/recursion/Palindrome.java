package recursion;

import java.util.Arrays;

public class Palindrome {

    public boolean isPalindrome(String word) {
        char[] chars = word.toCharArray();
        if (chars.length <= 1) {
            return true;
        } else if (chars[0] != chars[chars.length - 1]) {
            return false;
        } else {
            char[] partOfWord = Arrays.copyOfRange(chars, 1, chars.length - 1);
            return isPalindrome(new String(partOfWord));
        }
    }
}
