package classstructuremethods;

public class ClientMain {

    public static void main(String[] args) {

        Client client = new Client();

        String name = "Kovács Eugén";
        int year = 1965;
        String address = "3300 Eger, Kossuth u. 20.";
        String newAddress = "9400 Sopron, Várkerület 47.";

        client.changeName(name);
        client.changeYear(year);
        client.changeAddress(address);

        System.out.println("Name: " + client.getName());
        System.out.println("Year of Birth: " + client.getYear());
        System.out.println("Address: "+ client.getAddress());

        client.migrate(newAddress);

        System.out.println("The new address of the client is " + client.getAddress());

    }

}
