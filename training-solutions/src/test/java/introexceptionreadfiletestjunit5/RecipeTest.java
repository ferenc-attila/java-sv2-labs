package introexceptionreadfiletestjunit5;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RecipeTest {

    Recipe recipe = new Recipe();

    @Test
    void addIngredientsValidFileTest() {
        Path validPath = Paths.get("src/test/resources/recipe.txt");
        List<String> expectedList = Arrays.asList("liszt", "margarin", "kristálycukor", "tojás", "citrom", "sütőpor", "vanillincukor", "tejföl", "alma", "fahéj");

        recipe.addIngredients(validPath);
        assertEquals(expectedList, recipe.getIngredients());
    }

    @Test
    void addIngredientsInvalidFileTest() {
        Path invalidPath = Paths.get("src/test/resources/recipe_.txt");

        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> recipe.addIngredients(invalidPath));
        assertEquals("Unable to read file!", exception.getMessage());
    }
}