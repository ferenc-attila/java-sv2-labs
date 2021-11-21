package introexceptionwritefile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class RoadMap {

    public static void main(String[] args) {

        List<String> roadMap = Arrays.asList("Szihalom", "Füzesabony", "Dormánd", "Besenyőtelek", "Kömlő", "Tarnaszentmiklós");

        try {
            Files.write(Paths.get("roadmap.txt"), roadMap);
        } catch (IOException ioe) {
            System.out.println("Unable to write file!");
            ioe.printStackTrace();
        }
    }
}
