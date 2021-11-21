package introexceptionfinally;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Names {

    public static void main(String[] args) {

        Path namesWithSomeDoctors = Paths.get("src/main/resources/namesWithSomeDoctors.txt");
        Path names = Paths.get("src/main/resources/names.txt");


    }

    private List<String> readFiles(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Unable to read file!");
        }
    }

    private String findFirstDoctor(Path path) {
        List<String> contentOfFile = readFiles(path);
        for (String row : contentOfFile) {
            if ("dr.".equals(row.substring(0, 2))) {
                return row;
            }
        }
        return "";
    }
}
