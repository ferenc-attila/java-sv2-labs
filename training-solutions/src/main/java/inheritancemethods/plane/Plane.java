package inheritancemethods.plane;

public class Plane {

    public static void main(String[] args) {

        Passenger passenger = new Passenger("John Doe", 150_000);
        PriorityPassenger priorityPassenger = new PriorityPassenger("Jane Doe", 150_000, 20);
        FirstClassPassenger firstClassPassenger = new FirstClassPassenger("Jill Doe", 150_000, 20);

        System.out.println(passenger.getPriceOfPlaneTicket());
        System.out.println(priorityPassenger.getPriceOfPlaneTicket());
        System.out.println(firstClassPassenger.getPriceOfPlaneTicket());
    }
}
