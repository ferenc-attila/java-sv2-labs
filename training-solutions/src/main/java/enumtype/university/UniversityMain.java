package enumtype.university;

import java.util.Arrays;

public class UniversityMain {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(University.values()));
        System.out.println(University.valueOf("SE"));

        for (University uni : University.values()) {
            System.out.println(uni + ": " + uni.getName());
        }
    }
}
