package stringbuilder.airport;

import java.util.ArrayList;
import java.util.List;

public class Airport {

    private List<Flight> flights = new ArrayList<>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public StringBuilder getDeletedFlights() {
        StringBuilder deletedFlights = new StringBuilder("Törölt járatok:\n");
        for (Flight flight : flights){
            if (flight.getStatus() == Status.DELETED) {
                deletedFlights.append(flight.getFlightNumber() + "\n");
            }
        }
        return deletedFlights;
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
