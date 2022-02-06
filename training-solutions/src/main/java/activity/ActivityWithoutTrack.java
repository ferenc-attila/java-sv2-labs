package activity;

public class ActivityWithoutTrack implements Activity{

    private ActivityType type;

    public ActivityWithoutTrack(ActivityType type) {
        this.type = type;
    }

    @Override
    public double getDistance() {
        return 0;
    }

    @Override
    public ActivityType getType() {
        return type;
    }
}
