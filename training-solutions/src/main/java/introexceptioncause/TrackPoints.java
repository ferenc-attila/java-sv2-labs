package introexceptioncause;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TrackPoints {

    public List<String> readCsv(String filename) {
        try {
            return Files.readAllLines(Paths.get(filename));
        } catch (IOException ioe) {
            throw new IllegalStateException("No such file!", ioe);
        }
    }

    public List<Integer> getElevations(List<String> trackPoints) {
        List<Integer> elevations = new ArrayList<>();
        for (int i = 0; i < trackPoints.size(); i++) {
            String[] elevationString = trackPoints.get(i).split(";");
            try {
                int elevation = Integer.parseInt(elevationString[2]);
                elevations.add(elevation);
            } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException("Invalid elevation data in csv row nr. " + (i + 1), nfe);
            }
        }
        return elevations;
    }

    public List<Integer> getElevationGain(List<Integer> elevations) {
        List<Integer> elevationGains = new ArrayList<>();
        for (int i = 1; i < elevations.size(); i++) {
            elevationGains.add(elevations.get(i) - elevations.get(i - 1));
        }
        return elevationGains;
    }
}
