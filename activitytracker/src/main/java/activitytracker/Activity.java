package activitytracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Activity {

    private long id;
    private LocalDateTime startTime;
    private String desc;
    private Type type;
    private List<TrackPoint> trackPoints = new ArrayList<>();

    public Activity(long id, LocalDateTime startTime, String desc, Type type) {
        this.id = id;
        this.startTime = startTime;
        this.desc = desc;
        this.type = type;
    }

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    @Override
    public String toString() {
        return id + ": " + type.toString() + ", " + startTime + ", " + desc + trackPoints.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return id == activity.id && startTime.equals(activity.startTime) && desc.equals(activity.desc) && type == activity.type && trackPoints.equals(activity.trackPoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startTime, desc, type, trackPoints);
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getDesc() {
        return desc;
    }

    public Type getType() {
        return type;
    }

    public List<TrackPoint> getTrackPoints() {
        return List.copyOf(trackPoints);
    }
}
