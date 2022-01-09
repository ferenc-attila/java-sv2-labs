package exceptionresource.hiddenword;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class HiddenWord {

    public String getHiddenWord(Path path) {
        StringBuilder word = new StringBuilder();
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String alphabet = parseAlphabetFromLine(line);
                word.append(alphabet);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("No such file!");
        }
        return word.toString();
    }

    private String parseAlphabetFromLine(String line) {
        char[] chars = line.toCharArray();
        for (char c : chars) {
            if (Character.isAlphabetic(c)) {
                return Character.toString(c);
            }
        }
        return " ";
    }
}
