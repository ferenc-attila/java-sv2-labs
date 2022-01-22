package streamsalgorithms;

import java.time.LocalDate;
import java.util.*;

public class Employee {

    private String name;
    private int yearOfBirth;

    public Employee(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("Jane Doe", 1975),
                new Employee("Jill Doe", 1980),
                new Employee("Jack Doe", 1990),
                new Employee("John Doe", 1968),
                new Employee("Janet Doe", 1972),
                new Employee("Joe Doe", 1995)
        ));

        int sumOfYearOfBirth = employees.stream()
                .mapToInt(Employee::getYearOfBirth)
                .sum();

        System.out.println(sumOfYearOfBirth);

        int sumOfAges = employees.stream()
                .mapToInt(Employee::getYearOfBirth)
                .map(actual -> (LocalDate.now().getYear()) - actual)
                .sum();

        System.out.println(sumOfAges);

        long numberOfEmployees = employees.stream()
                .count();

        System.out.println(numberOfEmployees);

        long numberOfYoungerThan = employees.stream()
                .filter(employee -> employee.getYearOfBirth() > 1990)
                .count();

        System.out.println(numberOfYoungerThan);

       int yearOfBirthOfOldest = employees.stream()
                .mapToInt(Employee::getYearOfBirth)
                .min()
                .orElseThrow(() -> new IllegalArgumentException("Empty list of employees!"));

        System.out.println(yearOfBirthOfOldest);

        String nameOfOldest = employees.stream()
                .sorted(Comparator.comparingInt(Employee::getYearOfBirth))
                .map(employee -> employee.getName())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Empty list of employees!"));
        System.out.println(nameOfOldest);

        boolean areEveryEmployeeBirthBefore = employees.stream()
                .allMatch(employee -> employee.getYearOfBirth() < 1980);

        System.out.println(areEveryEmployeeBirthBefore);

        List<Employee> employeesBirthAfter = employees.stream()
                .filter(employee -> employee.getYearOfBirth() < 1990)
                .toList();

        System.out.println(employeesBirthAfter);

        List<String> nameOfAllEmployees = employees.stream()
                .map(employee -> employee.getName())
                .toList();

        System.out.println(nameOfAllEmployees);

        List<String> nameOfAllEmployeesBirthAfter = employees.stream()
                .filter(employee -> employee.getYearOfBirth() < 1990)
                .map(employee -> employee.getName())
                .toList();

        System.out.println(nameOfAllEmployeesBirthAfter);
    }
}
