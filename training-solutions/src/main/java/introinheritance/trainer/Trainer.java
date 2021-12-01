package introinheritance.trainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer extends Human {

    private List<Course> courses = new ArrayList<>();

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
