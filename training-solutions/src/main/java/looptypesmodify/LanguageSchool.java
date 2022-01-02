package looptypesmodify;

import java.util.ArrayList;
import java.util.List;

public class LanguageSchool {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        List<Student> inactiveStudents = new ArrayList<>();

        Student student1 = new Student("Jack Doe");
        students.add(student1);
        Student student2 = new Student("Jane Smith");
        students.add(student2);
        Student student3 = new Student("Lucky Luke");
        students.add(student3);
        Student student4 = new Student("Jane Taylor");
        students.add(student4);
        Student student5 = new Student("Bilbo Baggings");
        students.add(student5);

        students.get(1).setActive(false);
        students.get(4).setActive(false);

        for (Student student : students) {
            if (!student.isActive()) {
                inactiveStudents.add(student);
            }
        }
        System.out.println(students.size());
//        System.out.println(inactiveStudents.size());
        students.removeAll(inactiveStudents);
        System.out.println(students.size());
    }
}
