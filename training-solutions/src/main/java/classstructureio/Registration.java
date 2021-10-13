package classstructureio;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me your name!");
        String name = scanner.nextLine();

        System.out.println("Give me your e-mail address!");
        String email = scanner.nextLine();

        System.out.println("You registered with the following data:");
        System.out.println("Name: " + name + ";");
        System.out.println("email: " + email + ";");

    }
}