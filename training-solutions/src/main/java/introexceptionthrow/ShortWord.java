package introexceptionthrow;

import java.util.Scanner;

public class ShortWord {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a word not longer than 5 characters!");
        String shortWord = scanner.nextLine();

        if (shortWord.length() > 5) {
            throw new IllegalArgumentException(shortWord + " is longer than 5 characters!");
        }
        for (int i = 0; i < shortWord.length(); i++) {
            if (!Character.isLetter(shortWord.charAt(i))) {
                throw new IllegalArgumentException(shortWord + " contains characters other than letter!");
            }
        }
        System.out.println(shortWord);
    }
}
