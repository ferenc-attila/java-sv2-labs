package activity;

import org.jetbrains.annotations.NotNull;

public class TrackPoint {

    private static final int RADIUS_OF_EARTH = 6_371_000;

    private Coordinate coordinate;
    private double elevation;

    public TrackPoint(Coordinate coordinate, double elevation) {
        this.coordinate = coordinate;
        this.elevation = elevation;
    }

    public double getDistanceFrom(TrackPoint trackPoint) {
        double latitudeDistance = Math.toRadians(trackPoint.coordinate.getLatitude() - this.coordinate.getLatitude());
        double longitudeDistance = Math.toRadians(trackPoint.coordinate.getLongitude() - this.coordinate.getLongitude());
        double thisLatitudeInRadian = Math.toRadians(this.coordinate.getLatitude());
        double otherLatitudeInRadian = Math.toRadians(trackPoint.coordinate.getLatitude());
        double a = Math.pow(Math.sin(latitudeDistance / 2), 2)
                + Math.cos(thisLatitudeInRadian) * Math.cos(otherLatitudeInRadian)
                * Math.pow(Math.sin(longitudeDistance / 2), 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double height = this.elevation - trackPoint.elevation;
        return Math.sqrt(Math.pow(RADIUS_OF_EARTH * c, 2) + Math.pow(height, 2));
    }

    public Coordinate getCoordinate() {
        return new Coordinate(coordinate);
    }

    public double getElevation() {
        return elevation;
    }
}
