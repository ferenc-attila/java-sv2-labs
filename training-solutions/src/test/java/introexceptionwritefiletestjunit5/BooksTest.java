package introexceptionwritefiletestjunit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BooksTest {

    @TempDir
    File temporaryFolder;

    @Test
    void createReadableFileSuccessfulReadWriteTest() throws IOException {
        Path validReadPath = Paths.get("src/test/resources/books.txt");
        Path validWritePath = temporaryFolder.toPath().resolve("modifiedBooks.txt");

        List<String> expectedList = Arrays.asList("Gárdonyi Géza Egri csillagok", "Molnár Ferenc Pál utcai fiúk", "Fekete István Tüskevár", "Jókai Mór Kőszívű ember fiai");
        new Books().createReadableFile(validReadPath, validWritePath);
        List<String> lines = Files.readAllLines(validWritePath);
        assertEquals(expectedList, lines);
    }

    @Test
    void createReadableFileUnsuccessfulReadTest() {
        Path invalidReadPath = Paths.get("src/main/resources/books.txt");
        Path validWritePath = temporaryFolder.toPath().resolve("modifiedBooks.txt");

        IllegalStateException readException = assertThrows(IllegalStateException.class,
                () -> new Books().createReadableFile(invalidReadPath, validWritePath));

        assertEquals("Unable to read file!", readException.getMessage());
    }

    @Test
    void createReadableFileUnsuccessfulWriteTest() {
        Path validReadPath = Paths.get("src/test/resources/books.txt");
        Path invalidWritePath = Paths.get("/");

        IllegalStateException writeException = assertThrows(IllegalStateException.class,
                () -> new Books().createReadableFile(validReadPath, invalidWritePath));

        assertEquals("Unable to write file!", writeException.getMessage());
    }
}