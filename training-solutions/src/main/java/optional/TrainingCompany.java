package optional;

import java.util.List;
import java.util.Optional;

public class TrainingCompany {

    private List<Course> courses;

    public TrainingCompany(List<Course> courses) {
        this.courses = courses;
    }

    public Course getCheaperCourse(int maxPrice) {
        Optional<Course> result = Optional.empty();
        for (Course actual : courses) {
            if (maxPrice > actual.getPrice()) {
                result = Optional.of(actual);
            }
        }
        return result.orElseThrow(() -> new IllegalArgumentException("No such course."));
    }

    int getPriceOfCourseWithGivenNameAndLevel(String name, Level level) {
        Optional<Course> result = Optional.empty();
        for (Course actual : courses) {
            if (name.equals(actual.getName()) && level == actual.getLevel()) {
                result = Optional.of(actual);
            }
        }
        return result.orElseThrow(() -> new IllegalArgumentException("No such course.")).getPrice();
    }

    public String getNameOfCourseWithGivenLevel(Level level) {
        Optional<Course> result = Optional.empty();
        for (Course actual : courses) {
            if (level == actual.getLevel()) {
                result = Optional.of(actual);
            }
        }
        return result.orElse(new Course("Sorry, there is no course at this level.", Level.EXPERT, 0)).getName();
    }

    public List<Course> getCourses() {
        return courses;
    }
}
