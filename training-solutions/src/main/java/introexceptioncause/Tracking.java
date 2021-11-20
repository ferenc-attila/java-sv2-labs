package introexceptioncause;

import java.util.ArrayList;
import java.util.List;

public class Tracking {

    public static void main(String[] args) {

        TrackPoints trackPoints = new TrackPoints();

        List<String> trackPointsString = new ArrayList<>();

        try {
            trackPointsString = trackPoints.readCsv("tracking.csv");
        } catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
            ise.getCause().printStackTrace();
        }

        List<Integer> elevations = new ArrayList<>();
        try {
            elevations = trackPoints.getElevations(trackPointsString);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            iae.getCause().printStackTrace();
        }
        List<Integer> elevationGains = trackPoints.getElevationGain(elevations);

        for (int data : elevationGains) {
            System.out.println(data);
        }
    }
}
