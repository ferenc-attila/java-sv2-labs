package dynamictypes.publictransport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PublicTransportTest {

    PublicTransport bkv = new PublicTransport();

    @Test
    void createTest() {

        PublicVehicle bus = new Bus(12, 5.7, "Ikarus");
        PublicVehicle tram = new Tram(6, 12.5, 3);
        PublicVehicle metro = new Metro(4, 15.8, 8);
        bkv.addVehicle(bus);
        bkv.addVehicle(tram);
        bkv.addVehicle(metro);

        assertEquals(3, bkv.getVehicles().size());
        assertEquals("Ikarus", ((Bus)bkv.getVehicles().get(0)).getBrand());
        assertEquals(12.5, bkv.getVehicles().get(1).getLength());
        assertEquals(4, bkv.getVehicles().get(2).getLineNumber());
    }
}