package collectionsset;

import java.util.*;

public class PhysicalEducation {

    public Set<Integer> getOrderInLessons (List<Student> students) {
        Set<Integer> rowOfTowers = new TreeSet<>();
        for (Student actual : students) {
            rowOfTowers.add(actual.getHeight());
        }
        return rowOfTowers;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(new Student("Pistike", 157),
                new Student("Lacika", 184),
                new Student("Jánoska", 165),
                new Student("Gézuka", 167),
                new Student("Lacika", 167),
                new Student("Petike", 154)));

        PhysicalEducation pe = new PhysicalEducation();

        System.out.println(pe.getOrderInLessons(students));
    }
}
