package activitytracker;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.flywaydb.core.Flyway;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityMain {

    public void insertIntoActivities(Connection connection, List<Activity> activities) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO activities (start_time, activity_desc, activity_type) VALUES (?, ?, ?)")) {
            for (Activity activity : activities) {
                statement.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
                statement.setString(2, activity.getDesc());
                statement.setString(3, activity.getType().toString());
                statement.executeUpdate();
            }
        }
    }

    public Activity findActivityById(Connection connection, long id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("SELECT id, start_time, activity_desc, activity_type FROM activities WHERE id = ?")) {
            statement.setLong(1, id);
            return getActivity(id, statement);
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

    public List<Activity> getAllActivities(Connection connection) throws SQLException {
        List<Activity> activities = new ArrayList<>();
        try (Statement statement = connection.createStatement();
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
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("Invalid value in row with id: " + resultSet.getLong("id"));
        }
    }

    public static void main(String[] args) {
        Activity running = new Activity(0, LocalDateTime.of(2022, 1, 21, 10, 22), "A kiserdőig és vissza", Type.RUNNING);
        Activity biking = new Activity(1, LocalDateTime.of(2022, 1, 23, 14, 10), "A fürdőhöz", Type.BIKING);
        Activity hiking = new Activity(2, LocalDateTime.of(2022, 2, 12, 8, 44), "Felsőtárkányból a Tar-kőre", Type.HIKING);
        Activity basketball = new Activity(3, LocalDateTime.of(2022, 2, 14, 15, 55), "", Type.BASKETBALL);

        List<Activity> activities = new ArrayList<>();
        activities.add(running);
        activities.add(biking);
        activities.add(hiking);
        activities.add(basketball);

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/activitytracker?useUnicode=true");
        dataSource.setUser("activitytracker");
        dataSource.setPassword("activity");

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        try (Connection connection = dataSource.getConnection()) {
            ActivityMain main = new ActivityMain();
            main.insertIntoActivities(dataSource.getConnection(), activities);
            Activity foundedActivity = main.findActivityById(connection, 4);
            System.out.println(foundedActivity);
            List<Activity> activitiesInTable = main.getAllActivities(connection);
            System.out.println(activitiesInTable);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect to the database!");
        }
    }
}
