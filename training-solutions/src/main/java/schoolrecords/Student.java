package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private final String name;
    private List<Mark> marks = new ArrayList<>();

    public Student(String name) {
        isEmptyName(name);
        this.name = name;
    }

    private void isEmptyName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
    }

    public void grading(Mark mark) {
        isEmptyMark(mark);
        marks.add(mark);
    }

    private void isEmptyMark(Mark mark) {
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
    }

    public double calculateAverage() {
        double sumOfMarks = 0.0;
        for (Mark actual : marks) {
            sumOfMarks += actual.getMarkType().getGrade();
        }
        if (!marks.isEmpty()) {
            return Math.round((sumOfMarks / marks.size()) * 100.0) / 100.0;
        } else {
            return 0.0;
        }
    }

    //Real average calculation must be refactored (interface?)!
    public double calculateSubjectAverage(Subject subject) {
        double sumOfMarks = 0.0;
        int count = 0;
        for (Mark actual : marks) {
            if (actual.getSubject().getSubjectName().equals(subject.getSubjectName())) {
                sumOfMarks += actual.getMarkType().getGrade();
                count++;
            }
        }
        if (count > 0) {
            return Math.round((sumOfMarks / count) * 100.0) / 100.0;
        } else {
            return 0.0;
        }
    }

    @Override
    public String toString() {
        StringBuilder studentString = new StringBuilder(name + " marks: ");
        for (Mark actual : marks) {
            studentString.append(actual.getSubject().getSubjectName()).append(": ");
            studentString.append(actual);
            //group marks by subject
        }
        return studentString.toString();
    }

    public String getName() {
        return name;
    }
}
