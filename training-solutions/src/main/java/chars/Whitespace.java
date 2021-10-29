package chars;

public class Whitespace {

    public String makeWhiteSpaceToStar(String text) {
        String whitespaceToStar = "";
        char[] characters = text.toCharArray();
        for (char character : characters) {
            if (Character.isWhitespace(character)) {
                whitespaceToStar = whitespaceToStar + "*";
            } else {
                whitespaceToStar = whitespaceToStar + character;
            }
        }
        return whitespaceToStar;
    }
}
