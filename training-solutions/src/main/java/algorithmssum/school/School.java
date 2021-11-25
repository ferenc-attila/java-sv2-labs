package algorithmssum.school;

import java.util.List;

public class School {

    public int getNumberOfStudents(List<Integer> headcounts) {
        int sumOfStudents = 0;
        try {
            for (int headcount : headcounts) {
                sumOfStudents += headcount;
            }
        } catch (NullPointerException npe) {
            throw new IllegalArgumentException("There is at least one 'null' value in the list!", npe);
        }
        return sumOfStudents;
    }
}
