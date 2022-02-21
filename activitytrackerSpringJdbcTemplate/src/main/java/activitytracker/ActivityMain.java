package activitytracker;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityMain {

    private void insertActivities(List<Activity> activities, JdbcTemplate jdbcTemplate) {
        activities.forEach(activity ->
                jdbcTemplate.update(
                        "INSERT INTO activities (start_time, description, activity_type) VALUES (?, ?, ?)",
                        activity.getStartTime(), activity.getDescription(), activity.getType().toString()));
    }

    private List<Activity> findAllActivities(JdbcTemplate jdbcTemplate) {
        return jdbcTemplate.query("SELECT * FROM activities",
                (rs, rowNum) -> new Activity(rs.getLong("id"),
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getString("description"),
                        Type.valueOf(rs.getString("activity_type"))));
    }

    private Activity findActivityById(long id, JdbcTemplate jdbcTemplate) {
        return jdbcTemplate.queryForObject("SELECT * FROM activities WHERE id = ?", (rs, rowNum) -> new Activity(rs.getLong("id"),
                rs.getTimestamp("start_time").toLocalDateTime(),
                rs.getString("description"),
                Type.valueOf(rs.getString("activity_type"))), id);
    }

    public static void main(String[] args) {

        Activity running = new Activity(0L, LocalDateTime.of(2022, 1, 21, 10, 22), "A kiserdőig és vissza", Type.RUNNING);
        Activity biking = new Activity(1L, LocalDateTime.of(2022, 1, 23, 14, 10), "A fürdőhöz", Type.BIKING);
        Activity hiking = new Activity(2L, LocalDateTime.of(2022, 2, 12, 8, 44), "Felsőtárkányból a Tar-kőre", Type.HIKING);
        Activity basketball = new Activity(3L, LocalDateTime.of(2022, 2, 14, 15, 55), "", Type.BASKETBALL);

        List<Activity> activities = new ArrayList<>();
        activities.add(running);
        activities.add(biking);
        activities.add(hiking);
        activities.add(basketball);

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/activitytracker?useUnicode=true");
        dataSource.setUser("activitytracker");
        dataSource.setPassword("activity");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        ActivityMain main = new ActivityMain();

//        main.insertActivities(activities, jdbcTemplate);

        System.out.println(main.findAllActivities(jdbcTemplate));
        System.out.println(main.findActivityById(2, jdbcTemplate));
    }
}
