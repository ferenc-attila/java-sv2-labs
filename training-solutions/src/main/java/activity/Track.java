package activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    public void loadFromGpx () {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                Track.class.getResourceAsStream("/track.gpx")))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("   <trkpt")) {
                    Coordinate actual = ;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file!", ioe);
        }
    }

    public Coordinate findMaximumCoordinate() {
        return new Coordinate(getLatitudeStatistics().getMax(), getLongitudeStatistics().getMax());
    }

    public Coordinate findMinimumCoordinate() {
        return new Coordinate(getLatitudeStatistics().getMin(), getLongitudeStatistics().getMin());
    }

    private DoubleSummaryStatistics getLatitudeStatistics() {
        return trackPoints.stream()
                .mapToDouble(trackPoint -> trackPoint.getCoordinate().getLatitude())
                .summaryStatistics();
    }

    private DoubleSummaryStatistics getLongitudeStatistics() {
        return trackPoints.stream()
                .mapToDouble(trackPoint -> trackPoint.getCoordinate().getLongitude())
                .summaryStatistics();
    }

    public double getDistance() {
        double distance = 0;
        for (int i = 1; i < trackPoints.size(); i++) {
            distance += trackPoints.get(i - 1).getDistanceFrom(trackPoints.get(i));
        }
        return distance;
    }

    public double getFullElevation() {
        double elevation = 0;
        for (int i = 1; i < trackPoints.size(); i++) {
            if (getElevation(i) > 0) {
                elevation += getElevation(i);
            }
        }
        return elevation;
    }

    public double getFullDecrease() {
        double decrease = 0;
        for (int i = 1; i < trackPoints.size(); i++) {
            if (getElevation(i) < 0) {
                decrease += -1 * getElevation(i);
            }
        }
        return decrease;
    }

    private double getElevation(int i) {
        return trackPoints.get(i).getElevation() - trackPoints.get(i - 1).getElevation();
    }

    public double getRectangleArea() {
        return (findMaximumCoordinate().getLatitude() - findMinimumCoordinate().getLatitude()) * (findMaximumCoordinate().getLongitude() - findMinimumCoordinate().getLongitude());
    }

    public List<TrackPoint> getTrackPoints() {
        return List.copyOf(trackPoints);
    }
}
