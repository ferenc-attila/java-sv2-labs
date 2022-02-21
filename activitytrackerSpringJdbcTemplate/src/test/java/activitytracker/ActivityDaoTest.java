package activitytracker;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {

    ActivityDao activityDao;
    List<Activity> activities = new ArrayList<>();

    @BeforeEach
    void init() {
        Activity running = new Activity(0L, LocalDateTime.of(2022, 1, 21, 10, 22), "A kiserdőig és vissza", Type.RUNNING);
        Activity biking = new Activity(1L, LocalDateTime.of(2022, 1, 23, 14, 10), "A fürdőhöz", Type.BIKING);
        Activity hiking = new Activity(2L, LocalDateTime.of(2022, 2, 12, 8, 44), "Felsőtárkányból a Tar-kőre", Type.HIKING);
        Activity basketball = new Activity(3L, LocalDateTime.of(2022, 2, 14, 15, 55), "", Type.BASKETBALL);

        activities.add(running);
        activities.add(biking);
        activities.add(hiking);
        activities.add(basketball);

        MysqlDataSource dataSource = new MysqlDataSource();
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
        Activity expected = new Activity(1L, LocalDateTime.of(2022, 1, 21, 10, 22), "A kiserdőig és vissza", Type.RUNNING);
        assertEquals(expected, activityDao.findActivityById(1));
    }

    @Test
    void saveActivityAndGetIdTest() {
        activityDao.saveActivity(activities.get(1));
        Long id = activityDao.saveActivityAndGetId(activities.get(0));
        assertEquals(2L, id);
        assertEquals(Type.RUNNING, activityDao.findActivityById(id).getType());
    }

    @Test
    void findActivityByIdTest() {
        activityDao.saveActivityAndGetId(activities.get(0));
        activityDao.saveActivityAndGetId(activities.get(1));
        activityDao.saveActivityAndGetId(activities.get(2));
        activityDao.saveActivityAndGetId(activities.get(3));

        assertEquals("A fürdőhöz", activityDao.findActivityById(2).getDescription());
        assertEquals(LocalDateTime.parse("2022-02-14T15:55"), activityDao.findActivityById(4).getStartTime());
    }

    @Test
    void listActivitiesTest() {
        List<Activity> expected = new ArrayList<>();
        expected.add(activities.get(0));
        expected.add(activities.get(1));
        expected.add(activities.get(2));
        expected.add(activities.get(3));

        activityDao.saveActivity(activities.get(0));
        activityDao.saveActivity(activities.get(1));
        activityDao.saveActivity(activities.get(2));
        activityDao.saveActivity(activities.get(3));

        assertEquals(expected, activityDao.listActivities());
    }
}