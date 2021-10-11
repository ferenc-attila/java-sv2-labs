public class ClientMain {

    public static void main(String[] args) {

        Client client = new Client();

        client.setName("John Doe");
        client.setYearOfBirth(1989);
        client.setAddress("3300 Eger, Kossuth u. 20.");

        System.out.println("Név: " + client.getName());
        System.out.println("Születési év: " + client.getYearOfBirth());
        System.out.println("Cím: " + client.getAddress());

        client.migrate("2074 Perbál, Széchenyi u. 3.");

        System.out.println("Sikeres címváltoztatás!");
        System.out.println("Az új cím: " + client.getAddress());

    }
}
