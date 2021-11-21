package introexceptionfinally;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Names {

    public static void main(String[] args) {

        Names names = new Names();

        Path namesWithSomeDoctors = Paths.get("src/main/resources/namesWithSomeDoctors.txt");
        Path simpleNames = Paths.get("src/main/resources/names.txt");
        Path invalidPath = Paths.get("src/test/resources/names.txt");

        try {
            System.out.println(names.findFirstDoctor(namesWithSomeDoctors));
        } catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
            ise.getCause().printStackTrace();
        }

        try {
            System.out.println(names.findFirstDoctor(simpleNames));
        } catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
            ise.getCause().printStackTrace();
        }

        try {
            System.out.println(names.findFirstDoctor(invalidPath));
        } catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
            ise.getCause().printStackTrace();
        }
    }

    private List<String> readFiles(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Unable to read file!", ioe);
        }
    }

    private String findFirstDoctor(Path path) {
        List<String> contentOfFile = readFiles(path);
        for (String row : contentOfFile) {
            if ("dr.".equals(row.substring(0, 3))) {
                return row;
            }
        }
        return "";
    }
}
