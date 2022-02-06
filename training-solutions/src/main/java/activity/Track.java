package activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    public void loadFromGpx(InputStream inputStream) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                inputStream))) {
            addTrackPoints(br);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file!", ioe);
        } catch (NumberFormatException | NullPointerException exception) {
            throw new IllegalArgumentException("Invalid data in file!", exception);
        }
    }

    private void addTrackPoints(BufferedReader br) throws IOException {
        String line;
        Coordinate coordinate = null;
        while ((line = br.readLine()) != null) {
            if (line.startsWith("   <trkpt")) {
                coordinate = new Coordinate(Double.parseDouble(line.substring(15, 25)), Double.parseDouble(line.substring(32, 42)));
            }
            if (line.startsWith("    <ele>")) {
                createTrackPoint(line, coordinate);
            }
        }
    }

    private void createTrackPoint(String line, Coordinate coordinate) {
        TrackPoint trackPoint = new TrackPoint(coordinate, Double.parseDouble(line.substring(9, 14)));
        trackPoints.add(trackPoint);
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
