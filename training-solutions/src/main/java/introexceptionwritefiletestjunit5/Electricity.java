package introexceptionwritefiletestjunit5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Electricity {

    public void createFile(Path path) {
        try {
            Files.write(path, createPowerOutagesList());
        } catch (IOException ioe) {
            throw new IllegalStateException("Unable to write file", ioe);
        }
    }

    private List<String> createPowerOutagesList() {
        List<String> powerOutages = new ArrayList<>();
        powerOutages.add(LocalDate.now().toString());
        powerOutages.add("Kossuth u.");
        powerOutages.add("Széchenyi u.");
        powerOutages.add("Arany János u.");
        powerOutages.add("Petőfi u.");
        powerOutages.add("Béke u.");
        return powerOutages;
    }
}
