package primitivetypes.exam;

import java.util.ArrayList;
import java.util.List;

public class Exam {

    List<Person> examinees = new ArrayList<>();

    public void addPerson(Person person) {
        examinees.add(person);
    }

    public List<Person> getExaminees() {
        return examinees;
    }
}
