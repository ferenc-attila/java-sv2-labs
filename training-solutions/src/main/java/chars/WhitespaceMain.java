package chars;

public class WhitespaceMain {

    public static void main(String[] args) {

        String text = "     Mendegél a \n mandarin! ";
        System.out.println(text);

        Whitespace whitespace = new Whitespace();
        System.out.println(whitespace.makeWhiteSpaceToStar(text));
    }
}
