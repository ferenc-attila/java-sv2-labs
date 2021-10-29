package chars;

public class LettersAndDigitsAlternative {

    public String printLetterOrDigit(String text) {
        char[] characters = text.toCharArray();
        String letterOrDigit = "";
        for (char character : characters) {
            if (Character.isAlphabetic(character)) {
                letterOrDigit = letterOrDigit + character + " : letter\n";
            } else if (Character.isDigit(character)) {
                letterOrDigit = letterOrDigit + character + " : digit\n";
            } else {
                letterOrDigit = letterOrDigit + character + " : other\n";
            }
        }
        return letterOrDigit;
    }
}
