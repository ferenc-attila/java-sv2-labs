package activitytracker;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class ActivityDao {

    private static final double MAXIMUM_LATITUDE_VALUE = 90.0;
    private static final double MAXIMUM_LONGITUDE_VALUE = 180.0;

    private JdbcTemplate jdbcTemplate;

    public ActivityDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveActivity(Activity activity) {
        jdbcTemplate.update(
                "INSERT INTO activities (start_time, description, activity_type) VALUES (?, ?, ?)",
                activity.getStartTime(), activity.getDescription(), activity.getType().toString());
    }

    public long saveActivityAndGetId(Activity activity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> executeAndGetPreparedStatement(connection, activity), keyHolder);
        saveTrackPoints(activity, keyHolder.getKey().longValue());
        return keyHolder.getKey().longValue();
    }

    public Activity saveActivityAndReturnActivityWithId(Activity activity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> executeAndGetPreparedStatement(connection, activity), keyHolder);
        saveTrackPoints(activity, keyHolder.getKey().longValue());
        return findActivityById(keyHolder.getKey().longValue());
    }

    private PreparedStatement executeAndGetPreparedStatement(Connection connection, Activity activity) throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement("INSERT INTO activities (start_time, description, activity_type) VALUES (?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS);
        statement.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
        statement.setString(2, activity.getDescription());
        statement.setString(3, activity.getType().toString());
        return statement;
    }

    private void saveTrackPoints (Activity activity, long activityId) {
        for (TrackPoint actual : activity.getTrackPoints()) {
            validateTrackPoint(actual);
            jdbcTemplate.update("INSERT INTO track_points (id, activity_id, trackpoint_time, lat, lon) VALUES (?,?,?,?,?)",
                    actual.getId(), activityId, actual.getTime(), actual.getLat(), actual.getLon());
        }
    }

    private void validateTrackPoint(TrackPoint trackPoint) {
        if (Math.abs(trackPoint.getLat()) > MAXIMUM_LATITUDE_VALUE || Math.abs(trackPoint.getLon()) > MAXIMUM_LONGITUDE_VALUE) {
            throw new IllegalArgumentException("Invalid track point coordinates: " + trackPoint.getLat() + ";" + trackPoint.getLon());
        }
    }

    public Activity findActivityById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM activities WHERE id = ?", (rs, rowNum) -> new Activity(
                rs.getLong("id"),
                rs.getTimestamp("start_time").toLocalDateTime(),
                rs.getString("description"),
                Type.valueOf(rs.getString("activity_type"))), id);
    }

    public List<Activity> listActivities() {
        return jdbcTemplate.query("SELECT * FROM activities",
                (rs, rowNum) -> new Activity(rs.getLong("id"),
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getString("description"),
                        Type.valueOf(rs.getString("activity_type"))));
    }
}
