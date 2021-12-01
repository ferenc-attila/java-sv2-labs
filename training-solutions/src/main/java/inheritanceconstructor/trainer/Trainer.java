package inheritanceconstructor.trainer;

import java.util.List;

public class Trainer extends Human{

    public Trainer(String name, int age, List<Course> courses) {
        super(name, age);
        this.courses = courses;
    }

    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
