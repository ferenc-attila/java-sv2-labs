package junit5fixture;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    Employee employee = new Employee("John Doe", 1970);

//    @BeforeEach
//    void initEmployee(){
//        System.out.println("BeforeEach");
//        employee = new Employee();
//        employee.setName("John Doe");
//        employee.setYearOfBirth(1970);
//    }

    @Test
    void testCreate() {
        assertEquals("John Doe", employee.getName());
    }

    @Test
    void testGetAge() {
        assertEquals(30, employee.getAge(2000));
    }
}
