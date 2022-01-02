package intromethods.employee;

public class EmployeeMain {

    public static void main(String[] args) {

        Employee employee = new Employee("Jhon Doe", 2012, 250_000);
        System.out.println(employee);

        employee.setName("John Doe");
        employee.raiseSalary(50_000);
        System.out.println(employee);
    }
}
