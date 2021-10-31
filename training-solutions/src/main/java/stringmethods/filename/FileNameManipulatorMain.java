package stringmethods.filename;

import java.util.Arrays;
import java.util.List;

public class FileNameManipulatorMain {

    public static void main(String[] args) {

        FileNameManipulator fileNameManipulator = new FileNameManipulator();

        List<String> fileNames = Arrays.asList("test .txt", "test.java", "  test.java ", "  startwhitespae.txt", "upperCaseExtension.EXT", "   lot of whitespaces. txt    ", "upperCaseExtension.TXT");

        System.out.println(fileNameManipulator.compareFilesByName(fileNames.get(1), fileNames.get(2)));

        for (String fileName : fileNames) {
            System.out.println(fileNameManipulator.findFileExtension(fileName));

        }

        System.out.println(fileNameManipulator.changeExtensionToLowerCase(fileNames.get(4)));
        System.out.println(fileNameManipulator.changeExtensionToLowerCase(fileNames.get(6)));

        for (String fileName : fileNames) {
            System.out.println(fileNameManipulator.findLastCharacter(fileName));
        }

        for (String fileName : fileNames) {
            System.out.println(fileNameManipulator.identifyFilesByExtension("txt", fileName));
        }

        System.out.println(fileNameManipulator.replaceStringPart(fileNames.get(4), "seE", "see"));

        for (String fileName : fileNames) {
            System.out.println(fileNameManipulator.replaceStringPart(fileName, "\\s+", ""));
        }
    }
}
