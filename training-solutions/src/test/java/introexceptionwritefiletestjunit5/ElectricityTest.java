package introexceptionwritefiletestjunit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ElectricityTest {

    @TempDir
    File temporaryFolder;

    @Test
    void createFileTest() throws IOException {
        Path path = temporaryFolder.toPath().resolve("powerOutage.txt");
        new Electricity().createFile(path);

        List<String> powerOutage = Arrays.asList(LocalDate.now().toString(), "Kossuth u.", "Széchenyi u.", "Arany János u.", "Petőfi u.", "Béke u.");
        List<String> lines = Files.readAllLines(path);
        assertEquals(powerOutage, lines);
    }
}