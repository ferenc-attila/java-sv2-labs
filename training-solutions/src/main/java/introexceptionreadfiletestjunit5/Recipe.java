package introexceptionreadfiletestjunit5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private List<String> ingredients = new ArrayList<>();

    private List<String> readFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Unable to read file!", ioe);
        }
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void addIngredients(Path path) {
        List<String> rows = readFile(path);
        try {
            for (int i = 2; i < rows.size(); i++) {
                String[] row = (rows.get(i).split(" "));
                ingredients.add(row[2]);
            }
        } catch (IndexOutOfBoundsException iob) {
            System.out.println("Empty ingredients column!");
            iob.printStackTrace();
        }
    }
}
