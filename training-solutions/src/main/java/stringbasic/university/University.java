package stringbasic.university;

import java.util.ArrayList;
import java.util.List;

public class University {

    List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean areEqual(Student student, Student anotherStudent) {
        return student.getNeptunCode().equals(anotherStudent.getNeptunCode()) &&
                student.getEducationId().equals(anotherStudent.getEducationId());
    }

    public List<Student> getStudents() {
        return students;
    }
}
