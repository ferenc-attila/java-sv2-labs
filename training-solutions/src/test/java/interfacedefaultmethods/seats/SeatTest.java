package interfacedefaultmethods.seats;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeatTest {

    @Test
    void familyCarTest() {
        FamilyCar ford = new FamilyCar();
        assertEquals(5, ford.getNumberOfSeats());
    }

    @Test
    void sportCarTest() {
        SportsCar porsche = new SportsCar();
        assertEquals(2, porsche.getNumberOfSeats());
    }

    @Test
    void carTest() {
        Car mini = new Car("Mini", 4);
        assertEquals(4, mini.getNumberOfSeats());
     }
}
