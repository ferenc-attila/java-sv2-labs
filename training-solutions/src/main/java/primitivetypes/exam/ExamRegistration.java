package primitivetypes.exam;

import java.time.LocalDate;
import java.util.Scanner;

public class ExamRegistration {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of applicants you want to add:");
        int applicants = Integer.parseInt(sc.nextLine());
        Exam exam = new Exam();

        for (int i = 0; i < applicants; i++) {
            System.out.println("Details of the applicant nr. " + (i + 1) + ":");

            System.out.println("Enter the name:");
            String name = sc.nextLine();

            System.out.println("Enter the date of birth (as \"yyyy-mm-dd\"):");
            String dateStringOfBirth = sc.nextLine();
            LocalDate dateOfBirth = LocalDate.parse(dateStringOfBirth);

            System.out.println("Enter the postal code:");
            int postalCode = Integer.parseInt(sc.nextLine());

            System.out.println("Enter the average of grades:");
            double averageOfGrades = Double.parseDouble(sc.nextLine());

            Person person = new Person(name, dateOfBirth, postalCode, averageOfGrades);
            exam.addPerson(person);
        }

        for (Person person : exam.getExaminees()) {
            System.out.println(person.toString());
        }
    }
}
