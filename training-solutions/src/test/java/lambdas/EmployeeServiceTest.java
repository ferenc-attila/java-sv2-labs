package lambdas;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    @Test
    void findFirstTest() {
        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("John Doe"),
                new Employee("Jane Doe"),
                new Employee("Jack Doe")
        ));

        Employee result = new EmployeeService().findFirst(employees,
                employee -> employee.getName().startsWith("Jane"));

        assertEquals("Jane Doe", result.getName());
    }
}