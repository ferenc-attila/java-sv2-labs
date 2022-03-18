package entities;

import org.junit.jupiter.api.Test;
import entities.Client;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void validClientTest() {
        Client client = new Client("John Doe", "4521", 45, "john@example.com", "123456788");
        assertEquals("John Doe", client.getName());
        assertEquals("4521", client.getPostalCode());
        assertEquals(45, client.getAge());
        assertEquals("john@example.com", client.getEmail());
        assertEquals("123456788", client.getSocialSecurityNumber());
    }

    @Test
    void emptyNameTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Client("", "4521", 45, "john@example.com", "123456788"));
        assertEquals("Name cannot be empty!", iae.getMessage());
    }

    @Test
    void emptyPostalCodeTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Client("John Doe", "", 45, "john@example.com", "123456788"));
        assertEquals("Postal code cannot be empty!", iae.getMessage());
    }

    // After implementation, we need a test for postal code not in table of municipalities.

    @Test
    void tooYoungClientTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Client("John Doe", "4521", 10, "john@example.com", "123456788"));
        assertEquals("Age must be between 11 and 149!", iae.getMessage());
    }

    @Test
    void tooOldClientTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Client("John Doe", "4521", 150, "john@example.com", "123456788"));
        assertEquals("Age must be between 11 and 149!", iae.getMessage());
    }

    @Test
    void emptyEmailTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Client("John Doe", "4521", 45, "", "123456788"));
        assertEquals("Invalid e-mail address: !", iae.getMessage());
    }

    @Test
    void tooShortEmailTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Client("John Doe", "4521", 45, "j@ec", "123456788"));
        assertEquals("Invalid e-mail address: j@ec!", iae.getMessage());
    }

    @Test
    void atInWrongPlaceTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Client("John Doe", "4521", 45, "@j.ec", "123456788"));
        assertEquals("Invalid e-mail address: @j.ec!", iae.getMessage());
    }

    @Test
    void pointInWrongPlaceTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Client("John Doe", "4521", 45, "j@.ec", "123456788"));
        assertEquals("Invalid e-mail address: j@.ec!", iae.getMessage());
    }

    @Test
    void emptySocialSecurityNumberTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Client("John Doe", "4521", 45, "john@example.com", ""));
        assertEquals("Social security number must consist of 9 numeric characters!", iae.getMessage());
    }

    @Test
    void longSocialSecurityNumberTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Client("John Doe", "4521", 45, "john@example.com", "1234567891"));
        assertEquals("Social security number must consist of 9 numeric characters!", iae.getMessage());
    }

    @Test
    void shortSocialSecurityNumberTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Client("John Doe", "4521", 45, "john@example.com", "12345678"));
        assertEquals("Social security number must consist of 9 numeric characters!", iae.getMessage());
    }

    @Test
    void nonNumericCharacterInSocialSecurityNumberTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Client("John Doe", "4521", 45, "john@example.com", "12345678O"));
        assertEquals("Invalid character in social security number!", iae.getMessage());
        assertEquals(NumberFormatException.class, iae.getCause().getClass());
    }

    @Test
    void wrongCdvCodeTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Client("John Doe", "4521", 45, "john@example.com", "123456789"));
        assertEquals("Invalid CDV code in social security number!", iae.getMessage());
    }

    @Test
    void canGetVaccinationTest() {
        Client client = new Client(1L, "John Doe", "4521", 45, "john@example.com", "123456788", 2, LocalDate.of(2022, 2, 12));
        assertFalse(client.canGetVaccination(LocalDate.of(2022, 2, 26)));
        assertTrue(client.canGetVaccination(LocalDate.of(2022, 2, 27)));
    }
}