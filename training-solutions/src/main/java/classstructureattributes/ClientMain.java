package classstructureattributes;

import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) {

        Client client = new Client();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please insert your name:");
        client.name = scanner.nextLine();

        System.out.println("Please insert your year of birth:");
        client.year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please insert your address:");
        client.address = scanner.nextLine();

        System.out.println("You've provided the following informations:");
        System.out.println("Name: " + client.name);
        System.out.println("Year of birth: " + client.year);
        System.out.println("Address: " + client.address);

    }

}
