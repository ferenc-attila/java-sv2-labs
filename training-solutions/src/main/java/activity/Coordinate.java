package activity;

public class Coordinate {

    private static final double LATITUDE_EXTREME_VALUE = 90;
    private static final double LONGITUDE_EXTREME_VALUE = 180;

    private double latitude;
    private double longitude;

    public Coordinate(double latitude, double longitude) {
        validateLatitude(latitude);
        validateLongitude(longitude);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Coordinate(Coordinate coordinate) {
        this.latitude = coordinate.latitude;
        this.longitude = coordinate.longitude;
    }

    private void validateLatitude(double latitude) {
        if (Math.abs(latitude) > LATITUDE_EXTREME_VALUE) {
            throw new IllegalArgumentException("Invalid value of latitude: " + latitude);
        }
    }

    private void validateLongitude(double longitude) {
        if (Math.abs(longitude) > LONGITUDE_EXTREME_VALUE) {
            throw new IllegalArgumentException("Invalid value of longitude: " + longitude);
        }
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
