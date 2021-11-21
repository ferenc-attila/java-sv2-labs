package introexceptionwritefiletestjunit5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Books {

    public void createReadableFile(Path importPath, Path exportPath) {
        List<String> contentOfFile = readFile(importPath);
        List<String> readableList = createReadableList(contentOfFile);
        try {
            Files.write(exportPath, readableList);
        } catch (IOException ioeWrite) {
            throw new IllegalStateException("Unable to write file!", ioeWrite);
        }
    }

    private List<String> readFile(Path importPath) {
        try {
            return Files.readAllLines(importPath);
        } catch (IOException ioeRead) {
            throw new IllegalStateException("Unable to read file!", ioeRead);
        }
    }

    private List<String> createReadableList(List<String> contentOfFile) {
        List<String> readableList = new ArrayList<>();
        for (String row : contentOfFile) {
            String[] columns = row.split(";");
            readableList.add(columns[2] + " " + columns[1]);
        }
        return readableList;
    }
}
