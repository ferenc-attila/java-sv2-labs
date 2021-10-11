package classstructureattributes;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {

        Client newClient = new Client();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérlek, add meg a neved!");
        newClient.name = scanner.nextLine();
        System.out.println("Kérlek, add meg a születési éved!");
        newClient.yearOfBirth = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Kérlek add meg a címed!");
        newClient.address = scanner.nextLine();

        System.out.println("Név: " + newClient.name);
        System.out.println("Születési év: " + newClient.yearOfBirth);
        System.out.println("Cím: " + newClient.address);
    }
}
