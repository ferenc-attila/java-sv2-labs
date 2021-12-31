package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private String className;
    private Random random;
    private List<Student> students = new ArrayList<>();

    public ClassRecords(String className) {
        this.className = className;
        this.random = new Random();
    }

    public ClassRecords(String className, Random random) {
        this.className = className;
        this.random = random;
    }

    public boolean addStudent(Student student) {
        if (isStudentExists(student)) {
            return false;
        } else {
            students.add(student);
            return true;
        }
    }

    private boolean isStudentExists(Student student) {
        if (student == null) {
            throw new NullPointerException("Student can't be null!");
        }
        for (Student actual : students) {
            if (actual.getName().equals(student.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean removeStudent(Student student) {
        if (isStudentExists(student)) {
            students.remove(student);
            return true;
        }
        return false;
    }

    public double calculateClassAverage() {
        if (students.isEmpty()) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double sumOfAverages = 0.0;
        for (Student actual : students) {
            sumOfAverages += actual.calculateAverage();
        }
        validateSumOfAverages(sumOfAverages);
        return sumOfAverages / students.size();
    }

    private void validateSumOfAverages(double sumOfAverages) {
        if (sumOfAverages == 0.0) {
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }
    }

    public double calculateClassAverageBySubject(Subject subject) {
        double sumOfAveragesPerStudent = 0.0;
        int count = 0;
        for (Student actual : students) {
            if (actual.calculateSubjectAverage(subject) > 0.0) {
                sumOfAveragesPerStudent += actual.calculateSubjectAverage(subject);
                count++;
            }
        }
        validateSumOfAverages(sumOfAveragesPerStudent);
        if (count > 0) {
            return Math.round((sumOfAveragesPerStudent / count) * 100.0) / 100.0;
        } else {
            throw new IllegalArgumentException("Students don't yet have a grade for this subject, or the subject doesn't exist!");
        }
    }

    public Student findStudentByName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        if (students.isEmpty()) {
            throw new IllegalStateException("No students to search!");
        }
        for (Student actual : students) {
            if (actual.getName().equals(name)) {
                return actual;
            }
        }
        throw new IllegalArgumentException("Student by this name cannot be found! " + name);
    }

    public Student repetition() {
        if (students.isEmpty()) {
            throw new IllegalStateException("No students to select for repetition!");
        }
        int repetitive = random.nextInt(0, students.size());
        return students.get(repetitive);
    }

    public List<StudyResultByName> listStudyResults() {
        List<StudyResultByName> listOfStudyResults = new ArrayList<>();
        for (Student actual : students) {
            listOfStudyResults.add(new StudyResultByName(actual.getName(), actual.calculateAverage()));
        }
        return listOfStudyResults;
    }

    public String listStudentNames() {
        StringBuilder names = new StringBuilder();
        boolean first = true;
        for (Student actual : students) {
            if (first) {
                names.append(actual.getName());
                first = false;
            } else {
                names.append(", ").append(actual.getName());
            }
        }
        return names.toString();
    }

    public String getClassName() {
        return className;
    }
}
