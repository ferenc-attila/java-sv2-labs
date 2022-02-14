package activitytracker;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

    private DataSource dataSource;

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveActivity (Activity activity){
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO activities (start_time, activity_desc, activity_type) VALUES (?, ?, ?)")) {
                statement.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
                statement.setString(2, activity.getDesc());
                statement.setString(3, activity.getType().toString());
                statement.executeUpdate();
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot insert", sqle);
        }
    }

    public Activity findActivityById(long id) {
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT id, start_time, activity_desc, activity_type FROM activities WHERE id = ?")) {
            statement.setLong(1, id);
            return getActivity(id, statement);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot find activity!", sqle);
        }
    }

    private Activity getActivity(long id, PreparedStatement statement) throws SQLException {
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return new Activity(resultSet.getLong(1), resultSet.getTimestamp(2).toLocalDateTime(), resultSet.getString(3), Type.valueOf(resultSet.getString(4)));
            }
            throw new IllegalStateException("Cannot find activity with id: " + id);
        }
    }

    public List<Activity> listActivities() {
        List<Activity> activities = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT id, start_time, activity_desc, activity_type FROM activities")) {
            createListOfActivities(activities, resultSet);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Empty activity table", sqle);
        }
        return activities;
    }

    private void createListOfActivities(List<Activity> activities, ResultSet resultSet) throws SQLException {
        try {
            while (resultSet.next()) {
                activities.add(new Activity(resultSet.getLong(1),
                        resultSet.getTimestamp(2).toLocalDateTime(),
                        resultSet.getString(3),
                        Type.valueOf(resultSet.getString(4))));
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new IllegalArgumentException("Invalid value in row with id: " + resultSet.getLong("id"));
        }
    }
}
