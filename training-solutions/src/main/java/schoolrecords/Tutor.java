package schoolrecords;

import java.util.List;

public class Tutor {

    private String name;
    private List<Subject> taughtSubjects;

    public Tutor(String name, List<Subject> taughtSubjects) {
        validateName(name);
        validateTaughtSubjects(taughtSubjects);
        this.name = name;
        this.taughtSubjects = taughtSubjects;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be empty!");
        }
    }

    private void validateTaughtSubjects(List<Subject> taughtSubjects) {
        if (taughtSubjects.isEmpty()) {
            throw new IllegalArgumentException("List of taught subjects can't be empty!");
        }
    }

    public boolean tutorTeachingSubject (Subject subject) {
        validateSubject(subject);
        for (Subject actual : taughtSubjects) {
            if (actual.getSubjectName().equals(subject.getSubjectName())) {
                return true;
            }
        }
        return false;
    }

    private void validateSubject(Subject subject) {
        if (subject == null) {
            throw new NullPointerException("Subject can't be null!");
        }
    }

    public String getName() {
        return name;
    }
}
