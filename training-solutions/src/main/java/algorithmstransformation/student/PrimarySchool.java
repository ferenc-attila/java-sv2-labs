package algorithmstransformation.student;

import java.util.ArrayList;
import java.util.List;

public class PrimarySchool {

    private List<Person> persons;

    public PrimarySchool(List<Person> persons) {
        this.persons = persons;
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        for (Person person : this.persons) {
            if (person.getAge() < 16) {
                students.add(new Student(person.getName(), person.getAddress()));
            }
        }
        return students;
    }

    public void addPerson(Person person) {
        this.persons.add(person);
    }

    public List<Person> getPersons() {
        return persons;
    }
}
