package looptypes;

import java.util.Arrays;
import java.util.List;

public class StudyGroupMain {

    public static void main(String[] args) {

        StudyGroup studygroup = new StudyGroup();
        List<String> students = Arrays.asList("Roger Taylor", "Tarja Turunen", "Eddie Murphy", "Jane Smith", "John Doe");

        studygroup.printStudyGroups(students);
    }
}
