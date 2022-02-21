package activitytracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Activity {

    private Long id;
    private LocalDateTime startTime;
    private String description;
    private Type type;
    private List<TrackPoint> trackPoints = new ArrayList<>();

    public Activity(Long id, LocalDateTime startTime, String description, Type type) {
        this.id = id;
        this.startTime = startTime;
        this.description = description;
        this.type = type;
    }

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", description='" + description + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return startTime.equals(activity.startTime) && description.equals(activity.description) && type == activity.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, description, type);
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public List<TrackPoint> getTrackPoints() {
        return List.copyOf(trackPoints);
    }
}
