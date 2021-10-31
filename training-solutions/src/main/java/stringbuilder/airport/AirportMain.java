package stringbuilder.airport;

public class AirportMain {


    public static void main(String[] args) {

        Flight firstFlight = new Flight("L-12353", Status.ACTIVE);
        Flight secondFlight = new Flight("D-14525", Status.ACTIVE);
        Flight thirdFlight = new Flight("H-6898", Status.ACTIVE);
        Flight fourthFlight = new Flight("K-1528", Status.ACTIVE);
        Flight fifthFlight = new Flight("B-12", Status.ACTIVE);
        Flight sixthFlight = new Flight("L-487", Status.ACTIVE);

        Airport airport = new Airport();

        airport.addFlight(firstFlight);
        airport.addFlight(secondFlight);
        airport.addFlight(thirdFlight);
        airport.addFlight(fourthFlight);
        airport.addFlight(fifthFlight);
        airport.addFlight(sixthFlight);

        System.out.println(airport.getDeletedFlights());

        airport.getFlights().get(2).setStatus(Status.DELETED);
        airport.getFlights().get(5).setStatus(Status.DELETED);

        System.out.println(airport.getDeletedFlights());
    }
}
