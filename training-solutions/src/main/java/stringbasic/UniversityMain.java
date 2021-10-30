package stringbasic;

import java.util.Arrays;

public class UniversityMain {

    public static void main(String[] args) {

        University university = new University();

        Person JohnDoe = new Person("John Doe", "johndoe@mail.com", "1234556789",
                "123456-123456-123456", "+36-36-555-555");
        Person JoeDoe = new Person("Joe Doe", "joedoe@mail.com", "234567890",
                "234567-234567-234567", "+36-36-444-555");
        Person JaneDoe = new Person("Jane Doe", "janedoe@mail.com", "34567891",
                "345678-345678-345678", "+36-36-333-444");

        Student studentJohnDoe = new Student(JohnDoe, "ABC123", "GH987");
        Student studentJoeDoe = new Student(JoeDoe, "ABC123", "GH987");
        Student studentJaneDoe = new Student(JaneDoe, "DEF456", "IJ456");

        university.addStudent(studentJaneDoe);
        university.addStudent(studentJoeDoe);
        university.addStudent(studentJohnDoe);

        System.out.println(university.areEqual(university.getStudents().get(1), university.getStudents().get(2)));

        System.out.println(university.getStudents().get(0).getPerson().getName());
        System.out.println(university.getStudents().get(0).getPerson().getEmail());
        System.out.println(university.getStudents().get(0).getPerson().getTAJ());
        System.out.println(university.getStudents().get(0).getPerson().getBankAccountNumber());
        System.out.println(university.getStudents().get(0).getPerson().getPhoneNumber());
        System.out.println(university.getStudents().get(0).getNeptunCode());
        System.out.println(university.getStudents().get(0).getEducationId());
        System.out.println(university.getStudents().get(0).getEntranceCard());
    }
}
