package activitytracker;

import java.time.LocalDate;

public class TrackPoint {

    private Long id;
    private LocalDate time;
    private double lat;
    private double lon;

    public TrackPoint(Long id, LocalDate time, double lat, double lon) {
        this.id = id;
        this.time = time;
        this.lat = lat;
        this.lon = lon;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getTime() {
        return time;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
