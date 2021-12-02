package dynamictypes.publictransport;

import java.util.ArrayList;
import java.util.List;

public class PublicTransport {

    List<PublicVehicle> vehicles = new ArrayList<>();

    public void addVehicle(PublicVehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public List<PublicVehicle> getVehicles() {
        return vehicles;
    }
}
