package methodoverloading;

import java.util.Arrays;
import java.util.List;

public class ClassFiveA {

    private List<String> students = Arrays.asList("Kovács Péter", "Molnár Gizella", "Kiss József", "László Károly", "Molnár Ede", "Nagy Aurél", "Szabó Arnold");

    public String getTodayReferringStudent(int number) {
        try {
            return this.students.get(number - 1);
        } catch (IndexOutOfBoundsException iobe) {
            throw new IllegalArgumentException("Invalid number. Try number between 1 and the class size!");
        }
    }

    public String getTodayReferringStudent(Number number) {
        return this.students.get(number.getValue() - 1);
    }

    public String getTodayReferringStudent(String numberName) {
        return this.students.get(Number.valueOf(numberName.toUpperCase()).getValue() - 1);
    }

    public List<String> getStudents() {
        return students;
    }
}
