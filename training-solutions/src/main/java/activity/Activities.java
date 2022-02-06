package activity;

import java.util.*;

public class Activities {

    private List<Activity> activities;

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public int numberOfTrackActivities() {
        return (int) (activities.stream()
                .filter(activity -> activity.getClass() == ActivityWithTrack.class)
                .count());
    }

    public int numberOfWithoutTrackActivities() {
        return (int) (activities.stream()
                .filter(activity -> activity.getClass() == ActivityWithoutTrack.class)
                .count());
    }

    public List<Report> distancesByTypes() {
        Map<ActivityType, Double> activityReportMap = createActivityReportMap();
        return getReports(activityReportMap);
    }

    private List<Report> getReports(Map<ActivityType, Double> activityReportMap) {
        return activityReportMap.entrySet().stream()
                .map(entry -> new Report(entry.getKey(), entry.getValue()))
                .toList();
    }

    private Map<ActivityType, Double> createActivityReportMap() {
        Map<ActivityType, Double> activityReportMap = initActivityReportMap();
        activities.stream()
                .map(Activity::getType)
                .distinct()
                .forEach(type -> activityReportMap.put(type, getSumOfDistancesByType(type)));
        return activityReportMap;
    }

    private Map<ActivityType, Double> initActivityReportMap() {
        Map<ActivityType, Double> activityReportMap = new TreeMap<>();
        for (ActivityType type : ActivityType.values()) {
            activityReportMap.put(type, 0.0);
        }
        return activityReportMap;
    }

    private double getSumOfDistancesByType(ActivityType type) {
        return activities.stream()
                .filter(activity -> activity.getType() == type)
                .mapToDouble(Activity::getDistance)
                .sum();
    }
}
