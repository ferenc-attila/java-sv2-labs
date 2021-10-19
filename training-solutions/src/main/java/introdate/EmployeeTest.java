package introdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class EmployeeTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the employee:");
        String name = scanner.nextLine();
        System.out.println("Enter the date of birth of the employee:");
        System.out.println("Year:");
        int yearOfBirth = scanner.nextInt();
        System.out.println("Month:");
        int monthOfBirth = scanner.nextInt();
        System.out.println("Day:");
        int dayOfBirth = scanner.nextInt();

        LocalDate dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);

        Employee employee = new Employee(name, dateOfBirth, LocalDateTime.now());

        System.out.print("Details of the newly hired employee:\n" +
                        "Name: "+ employee.getName() + ";\n" +
                        "Date of birth: " + employee.getDateOfBirth() + ";\n" +
                        "Beginning of employment: " + employee.getBeginEmployment() + ";");
    }
}
