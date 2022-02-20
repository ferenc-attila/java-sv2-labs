package activitytracker;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {

    ActivityDao activityDao;
    MysqlDataSource dataSource;
    List<Activity> activities = new ArrayList<>();

    @BeforeEach
    void init() {
        Activity running = new Activity(0, LocalDateTime.of(2022, 1, 21, 10, 22), "A kiserdőig és vissza", Type.RUNNING);
        Activity biking = new Activity(1, LocalDateTime.of(2022, 1, 23, 14, 10), "A fürdőhöz", Type.BIKING);
        Activity hiking = new Activity(2, LocalDateTime.of(2022, 2, 12, 8, 44), "Felsőtárkányból a Tar-kőre", Type.HIKING);
        Activity basketball = new Activity(3, LocalDateTime.of(2022, 2, 14, 15, 55), "", Type.BASKETBALL);

        activities.add(running);
        activities.add(biking);
        activities.add(hiking);
        activities.add(basketball);

        dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/activitytracker_test?useUnicode=true");
        dataSource.setUser("activitytracker");
        dataSource.setPassword("activity");

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        activityDao = new ActivityDao(dataSource);
    }

    @Test
    void saveActivityTest() {
        activityDao.saveActivity(activities.get(0));
        Activity expected = new Activity(1, LocalDateTime.of(2022, 1, 21, 10, 22), "A kiserdőig és vissza", Type.RUNNING);
        assertEquals(expected, activityDao.findActivityById(1));
    }

    @Test
    void saveActivityAnsReturnActivityWithIdTest() {
        Activity activity = activityDao.saveActivityAndReturnActivityWithId(activities.get(0));
        assertEquals(activity, activityDao.findActivityById(1));
    }

    @Test
    void saveActivityWithTrackPointsTest() {
        Activity expected = new Activity(1, LocalDateTime.of(2022, 1, 21, 10, 22), "A kiserdőig és vissza", Type.RUNNING);

        TrackPoint trackPoint1 = new TrackPoint(0L, LocalDate.of(2020, 1, 2), 47.5542, 21.2565);
        TrackPoint trackPoint2 = new TrackPoint(1L, LocalDate.of(2020, 1, 2), 47.5553, 21.2557);
        TrackPoint trackPoint3 = new TrackPoint(2L, LocalDate.of(2020, 1, 2), 47.5548, 21.2540);
        TrackPoint trackPoint4 = new TrackPoint(3L, LocalDate.of(2020, 1, 2), 47.5564, 21.2538);

        expected.addTrackPoint(trackPoint1);
        expected.addTrackPoint(trackPoint2);
        expected.addTrackPoint(trackPoint3);
        expected.addTrackPoint(trackPoint4);

        activities.get(0).addTrackPoint(trackPoint1);
        activities.get(0).addTrackPoint(trackPoint2);
        activities.get(0).addTrackPoint(trackPoint3);
        activities.get(0).addTrackPoint(trackPoint4);

        Activity foundedActivity = activityDao.saveActivityWithTrackPoints(activities.get(0));
        assertEquals(expected, foundedActivity);
    }

    @Test
    void addActivityWithEmptyTrackPoints() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> activityDao.saveActivityWithTrackPoints(activities.get(0)));
        assertEquals("Transaction failed!", iae.getMessage());
        assertEquals("Empty list of track points!", iae.getCause().getMessage());
    }

    @Test
    void addActivityWithInvalidCoordinates() {
        TrackPoint trackPoint1 = new TrackPoint(0L, LocalDate.of(2020, 1, 2), 47.5542, 21.2565);
        TrackPoint trackPoint2 = new TrackPoint(1L, LocalDate.of(2020, 1, 2), 47.5553, 21.2557);
        TrackPoint trackPoint3 = new TrackPoint(2L, LocalDate.of(2020, 1, 2), 90.5548, 180.2540);
        TrackPoint trackPoint4 = new TrackPoint(3L, LocalDate.of(2020, 1, 2), 47.5564, 21.2538);

        activities.get(0).addTrackPoint(trackPoint1);
        activities.get(0).addTrackPoint(trackPoint2);
        activities.get(0).addTrackPoint(trackPoint3);
        activities.get(0).addTrackPoint(trackPoint4);

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> activityDao.saveActivityWithTrackPoints(activities.get(0)));
        assertEquals("Invalid coordinate values: 90.5548;180.254", iae.getCause().getMessage());
    }

    @Test
    void findActivityByIdTest() {
        activityDao.saveActivityAndReturnActivityWithId(activities.get(0));
        activityDao.saveActivityAndReturnActivityWithId(activities.get(1));
        activityDao.saveActivityAndReturnActivityWithId(activities.get(2));
        activityDao.saveActivityAndReturnActivityWithId(activities.get(3));

        assertEquals("A fürdőhöz", activityDao.findActivityById(2).getDesc());
        assertEquals(LocalDateTime.parse("2022-02-14T15:55"), activityDao.findActivityById(4).getStartTime());
    }

    @Test
    void findActivityByNonExistentIdTest() {
        activityDao.saveActivity(activities.get(0));
        activityDao.saveActivity(activities.get(1));
        activityDao.saveActivity(activities.get(2));
        activityDao.saveActivity(activities.get(3));

        IllegalStateException ise = assertThrows(IllegalStateException.class, () -> activityDao.findActivityById(10));
        assertEquals("Cannot find activity with this id: '10'!", ise.getMessage());
    }

    @Test
    void listActivitiesTest() {
        List<Activity> expected = new ArrayList<>();
        expected.add(activityDao.saveActivityAndReturnActivityWithId(activities.get(0)));
        expected.add(activityDao.saveActivityAndReturnActivityWithId(activities.get(1)));
        expected.add(activityDao.saveActivityAndReturnActivityWithId(activities.get(2)));
        expected.add(activityDao.saveActivityAndReturnActivityWithId(activities.get(3)));

        assertEquals(expected, activityDao.listActivities());
    }

    @Test
    void invalidDatabaseTest() {
        MysqlDataSource invalidDataSource = new MysqlDataSource();
        invalidDataSource.setURL("jdbc:mysql://localhost:3306/activitytracker_invalid?useUnicode=true");
        invalidDataSource.setUser("activitytracker");
        invalidDataSource.setPassword("activity");

        activityDao = new ActivityDao(invalidDataSource);

        IllegalStateException ise = assertThrows(IllegalStateException.class, () -> activityDao.saveActivity(activities.get(1)));
        assertEquals("Cannot insert", ise.getMessage());
        assertEquals(SQLSyntaxErrorException.class, ise.getCause().getClass());
        assertTrue(ise.getCause().getMessage().startsWith("Access denied for user 'activitytracker'"));
    }

    @Test
    void invalidUserTest() {
        MysqlDataSource invalidDataSource = new MysqlDataSource();
        invalidDataSource.setURL("jdbc:mysql://localhost:3306/activitytracker_test?useUnicode=true");
        invalidDataSource.setUser("activity");
        invalidDataSource.setPassword("activity");

        activityDao = new ActivityDao(invalidDataSource);

        IllegalStateException ise = assertThrows(IllegalStateException.class, () -> activityDao.saveActivity(activities.get(1)));
        assertEquals("Cannot insert", ise.getMessage());
        assertEquals(SQLException.class, ise.getCause().getClass());
        assertTrue(ise.getCause().getMessage().startsWith("Access denied for user 'activity'"));
    }

    @Test
    void invalidPasswordTest() {
        MysqlDataSource invalidDataSource = new MysqlDataSource();
        invalidDataSource.setURL("jdbc:mysql://localhost:3306/activitytracker_test?useUnicode=true");
        invalidDataSource.setUser("activitytracker");
        invalidDataSource.setPassword("acti");

        activityDao = new ActivityDao(invalidDataSource);

        IllegalStateException ise = assertThrows(IllegalStateException.class, () -> activityDao.saveActivity(activities.get(1)));
        assertEquals("Cannot insert", ise.getMessage());
        assertEquals(SQLException.class, ise.getCause().getClass());
        assertTrue(ise.getCause().getMessage().startsWith("Access denied for user 'activitytracker'"));
    }
}