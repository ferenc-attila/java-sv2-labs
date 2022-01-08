package exceptionclass.course;

public class Course {

    private String name;
    private SimpleTime begin;

    public Course(String name, SimpleTime begin) {
        validateName(name);
        validateBeginningTime(begin);
        this.name = name;
        this.begin = begin;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is null!");
        }
    }

    private void validateBeginningTime(SimpleTime time) {
        if (time == null) {
            throw new IllegalArgumentException("Begin is null!");
        }
    }

    @Override
    public String toString() {
        return begin + ": " + name;
    }

    public String getName() {
        return name;
    }

    public SimpleTime getBegin() {
        return begin;
    }
}
