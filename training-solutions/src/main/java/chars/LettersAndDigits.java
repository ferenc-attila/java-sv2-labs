package chars;

public class LettersAndDigits {

    public String printLetterOrDigit(String text) {
        char[] characters = text.toCharArray();
        String letterOrDigit = "";
        for (char character : characters) {
            if (65 <= (int) character && (int) character < 91 || (97 <= (int) character && (int) character < 123)) {
                letterOrDigit = letterOrDigit + character + " : letter\n";
            } else if (48 <= (int) character && (int) character < 58) {
                letterOrDigit = letterOrDigit + character + " : digit\n";
            } else {
                letterOrDigit = letterOrDigit + character + " : other\n";
            }
        }
        return letterOrDigit;
    }
}
