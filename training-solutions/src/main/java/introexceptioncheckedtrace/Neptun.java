package introexceptioncheckedtrace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Neptun {

    public static void main(String[] args) {

        Neptun neptun = new Neptun();

        List<String> contentOfFile;
        try {
            contentOfFile = neptun.readCsv("src/main/resources/neptun.csv");
            System.out.println(neptun.getNeptunCodes(contentOfFile));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private List<String> getNeptunCodes(List<String> contentOfFile) {
        List<String> neptunCodes = new ArrayList<>();
        for (String row : contentOfFile) {
            neptunCodes.add(row.substring(row.indexOf(',') + 1));
        }
        return neptunCodes;
    }

    private List<String> readCsv(String filename) throws IOException {
        return Files.readAllLines(Paths.get(filename));
    }
}
