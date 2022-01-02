package interfacedefaultmethods.longword;

import java.nio.file.Path;
import java.util.List;

public class LongWord implements FileOperations{

    private Path path;

    public LongWord(Path path) {
        this.path = path;
    }

    @Override
    public String getLongWord() {
        List<String> fileContent = readFromFile(path);
        StringBuilder longWord = new StringBuilder();
        boolean first = true;
        for (String row : fileContent) {
            if (first) {
                longWord.append(row);
                first = false;
            } else {
                longWord.append(row.substring(row.length()-1));
            }
        }
        return longWord.toString();
    }
}
