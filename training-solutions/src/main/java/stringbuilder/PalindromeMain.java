package stringbuilder;

public class PalindromeMain {

    public static void main(String[] args) {

        PalindromeValidator palindrome = new PalindromeValidator();

        System.out.println(palindrome.isPalindrome("káposzta"));
        System.out.println(palindrome.isPalindrome("görög"));
        System.out.println(palindrome.isPalindrome("báb"));
        System.out.println(palindrome.isPalindrome("pap"));
        System.out.println(palindrome.isPalindrome("seres"));
        System.out.println(palindrome.isPalindrome("KantárABarátnak"));
        System.out.println(palindrome.isPalindrome("IndulARútDagadtÚrAludni"));
        System.out.println(palindrome.isPalindrome("redivider"));
        System.out.println(palindrome.isPalindrome("madam"));
        System.out.println(palindrome.isPalindrome("civic"));
        System.out.println(palindrome.isPalindrome("refer"));
    }
}
