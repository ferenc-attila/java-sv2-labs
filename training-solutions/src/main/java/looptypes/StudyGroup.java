package looptypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudyGroup {

    public static void printStudyGroups(List<String> students) {
        List<String> longNameStudents = new ArrayList<>(Arrays.asList());
        List<String> shortNameStudents = new ArrayList<>(Arrays.asList());

        for (String student : students) {
            if (student.length() > 10) {
                longNameStudents.add(student);
            } else {
                shortNameStudents.add(student);
            }
        }
        System.out.println(longNameStudents);
        System.out.println(shortNameStudents);
    }
}
