package introcontrol;

import java.util.Scanner;

public class UserMenu {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Listing users");
        System.out.println("2. Add new users");
        System.out.println("Other: Exit");
        System.out.println("Select an option");

        int option = scanner.nextInt();

        if (option == 1) {
            System.out.println("Listing users");
        } else if (option == 2) {
            System.out.println("Add new users");
        } else {
            return;
        }
    }
}
