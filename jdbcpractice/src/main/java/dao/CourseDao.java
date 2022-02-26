package dao;

import model.Course;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class CourseDao implements Dao<Course> {

    private JdbcTemplate jdbcTemplate;

    public CourseDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Course> list() {
        return jdbcTemplate.query("SELECT * FROM courses",
                (rs, rowNum) -> new Course(
                        rs.getLong("course_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("link"))
        );
    }

    @Override
    public void create(Course course) {
        jdbcTemplate.update("INSERT INTO courses(title, description, link) VALUES (?,?,?)",
                course.getTitle(), course.getDescription(), course.getLink());

    }

    @Override
    public Optional<Course> get(int id) {
        return Optional.ofNullable(
                jdbcTemplate.queryForObject("SELECT * FROM courses WHERE course_id = ?",
                        (rs, rowNum) -> new Course(
                                rs.getLong("course_id"),
                                rs.getString("title"),
                                rs.getString("description"),
                                rs.getString("link")),
                        id
                ));
    }

    @Override
    public void update(Course course, int id) {
        jdbcTemplate.update("UPDATE courses SET title = ?, description = ?, link = ? WHERE course_id = ?",
                course.getTitle(), course.getDescription(), course.getLink(), id);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM courses WHERE course_id = ?", id);
    }
}
