package primitivetypes.exam;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExamRegistration {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of applicants you want to add:");
        int applicants = Integer.parseInt(sc.nextLine());
        Exam exam = new Exam();

        for (int i = 0; i < applicants; i++) {
            System.out.println("Details of the applicant nr. " + i + 1 + ":");
            System.out.println("Enter the name:");
            String name = sc.nextLine();
            System.out.println("Enter the date of birth (as \"yyyy-mm-dd\"):");
            String dateOfBirth = sc.nextLine();
            int yearOfBirth = Integer.parseInt(dateOfBirth.substring(0, 4));
            int monthOfBirth = Integer.parseInt(dateOfBirth.substring(5, 7));
            int dayOfBirth = Integer.parseInt(dateOfBirth.substring(8, 9));
            System.out.println("Enter the postal code:");
            int postalCode = Integer.parseInt(sc.nextLine());
            System.out.println("Enter the average of grades:");
            double averageOfGrades = Double.parseDouble(sc.nextLine());
            Person person = new Person(name, LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth), postalCode, averageOfGrades);
            exam.addPerson(person);
        }
        for (Person examinee : exam.getExaminees()) {
            System.out.println(examinee.toString());
        }
    }
}
