package activitytracker;

import javax.sql.DataSource;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

    public static final double MAX_LATITUDE_VALUE = 90.0;
    public static final double MAX_LONGITUDE_VALUE = 180.0;

    private DataSource dataSource;

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveActivity(Activity activity) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO activities (start_time, activity_desc, activity_type) VALUES (?, ?, ?)")
        ) {
            setStatementValues(activity, statement);
            statement.executeUpdate();
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot insert", sqle);
        }
    }

    public Activity saveActivityAndReturnActivityWithId(Activity activity) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO activities (start_time, activity_desc, activity_type) VALUES (?, ?, ?)",
                     Statement.RETURN_GENERATED_KEYS)) {
            setStatementValues(activity, statement);
            statement.executeUpdate();
            return new Activity(getIdByStatement(statement), activity.getStartTime(), activity.getDesc(), activity.getType());
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot insert", sqle);
        }
    }

    public Activity saveActivityWithTrackPoints(Activity activity) {
        Long activityId = saveActivityAndReturnActivityWithId(activity).getId();
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            runPreparedStatement(activity, activityId, connection);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect!", sqle);
        }
        return getActivityWithTrackPoints(activityId);
    }

    public Activity findActivityById(long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM activities WHERE id = ?")) {
            statement.setLong(1, id);
            return getActivity(id, statement);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    public List<Activity> listActivities() {
        List<Activity> activities = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM activities")) {
            createListOfActivities(activities, resultSet);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Empty activity table", sqle);
        }
        return activities;
    }

    public void saveImageToActivity(long activityId, Image image) {
        InputStream imageStream = ActivityDao.class.getResourceAsStream("/"+image.getFilename());
        try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO images activity_id, filename, content VALUES (?, ?, ?)" )) {
            Blob blob = connection.createBlob();
            try (OutputStream output = blob.setBinaryStream(1);
                 BufferedInputStream input = new BufferedInputStream(imageStream)) {
                input.transferTo(output);
            } catch (SQLException | IOException e) {
                throw new IllegalStateException("Cannot create blob", e);
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect!");
        }
    }

    private void runPreparedStatement(Activity activity, Long activityId, Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO track_point (activity_id, trackpoint_time, lat, lon) VALUES (?, ?, ?, ?)")) {
            saveTrackPoints(activityId, activity, statement);
            connection.commit();
        } catch (IllegalArgumentException iae) {
            connection.rollback();
            throw new IllegalArgumentException("Transaction failed!", iae);
        }
    }

    private Activity getActivityWithTrackPoints(Long activityId) {
        Activity result = findActivityById(activityId);
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM track_point WHERE activity_id = ?;")) {
            statement.setLong(1, activityId);
            addTrackPointsFromTable(result, statement);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect");
        }
        return result;
    }

    private void addTrackPointsFromTable(Activity result, PreparedStatement statement) {
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                result.addTrackPoint(new TrackPoint(resultSet.getLong("id"),
                        resultSet.getDate("trackpoint_time").toLocalDate(),
                        resultSet.getDouble("lat"),
                        resultSet.getDouble("lon")));
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot get result");
        }
    }

    private void saveTrackPoints(Long activityId, Activity activity, PreparedStatement statement) throws SQLException {
        checkTrackPoints(activity);
        for (TrackPoint actual : activity.getTrackPoints()) {
            validateCoordinates(actual);
            statement.setLong(1, activityId);
            statement.setDate(2, Date.valueOf(actual.getTime()));
            statement.setDouble(3, actual.getLat());
            statement.setDouble(4, actual.getLon());
            statement.executeUpdate();
        }
    }

    private void validateCoordinates(TrackPoint trackPoint) {
        if (Math.abs(trackPoint.getLat()) > MAX_LATITUDE_VALUE || Math.abs(trackPoint.getLon()) > MAX_LONGITUDE_VALUE) {
            throw new IllegalArgumentException("Invalid coordinate values: " + trackPoint.getLat() + ";" + trackPoint.getLon());
        }
    }

    private void checkTrackPoints(Activity activity) {
        if (activity.getTrackPoints().isEmpty()) {
            throw new IllegalArgumentException("Empty list of track points!");
        }
    }

    private void setStatementValues(Activity activity, PreparedStatement statement) throws SQLException {
        statement.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
        statement.setString(2, activity.getDesc());
        statement.setString(3, activity.getType().toString());
    }

    private long getIdByStatement(PreparedStatement statement) {
        try (ResultSet resultSet = statement.getGeneratedKeys()) {
            if (resultSet.next()) {
                return resultSet.getLong(1);
            }
            throw new IllegalStateException("Cannot get id!");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot get id, sqle");
        }
    }

    private Activity getActivity(long id, PreparedStatement statement) throws SQLException {
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return new Activity(resultSet.getLong("id"),
                        resultSet.getTimestamp("start_time").toLocalDateTime(),
                        resultSet.getString("activity_desc"),
                        Type.valueOf(resultSet.getString("activity_type")));
            }
            throw new IllegalStateException("Cannot find activity with this id: '" + id + "'!");
        }
    }

    private void createListOfActivities(List<Activity> activities, ResultSet resultSet) throws SQLException {
        try {
            while (resultSet.next()) {
                activities.add(new Activity(resultSet.getLong("id"),
                        resultSet.getTimestamp("start_time").toLocalDateTime(),
                        resultSet.getString("activity_desc"),
                        Type.valueOf(resultSet.getString("activity_type"))));
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new IllegalArgumentException("Invalid value in row with id: " + resultSet.getLong("id"));
        }
    }
}
