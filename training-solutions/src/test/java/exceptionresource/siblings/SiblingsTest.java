package exceptionresource.siblings;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SiblingsTest {

    @Test
    void getFullNamesTest() {
        Path path = Path.of("src/test/resources/siblings.txt");
        String lastName = "Doe";
        Siblings siblings = new Siblings();

        List<String> family = siblings.getFullNames(lastName, path);
        assertEquals(4, family.size());
        assertEquals("Doe Joseph", family.get(3));
    }
}