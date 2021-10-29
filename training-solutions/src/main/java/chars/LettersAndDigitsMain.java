package chars;

public class LettersAndDigitsMain {

    public static void main(String[] args) {

        String text = "$123AzépLKjZAaz/*09-gfHUZZT785ujxs";

        LettersAndDigits lettersAndDigits = new LettersAndDigits();
        System.out.println(lettersAndDigits.printLetterOrDigit(text));

        LettersAndDigitsAlternative lettersAndDigitsAlternative = new LettersAndDigitsAlternative();
        System.out.println(lettersAndDigits.printLetterOrDigit(text));
    }
}
