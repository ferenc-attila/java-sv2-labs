package introcontrol;

import java.util.Scanner;

public class BoatRental {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of guests:");
        int numberOfGuests = scanner.nextInt();
        int linedUp = 0;

        if (numberOfGuests <= 0) {
            System.out.println("Not a valid number! Enter a positive integer!");
        }

        if (numberOfGuests > 10) {
            linedUp = numberOfGuests - 10;
            numberOfGuests = 10;
        }

        if (numberOfGuests <= 2) {
            System.out.println("The boat for 2 ran out, there are still 8 free seats.");
        } else if (numberOfGuests == 3) {
            System.out.println("The boat for 3 ran out, there are still 7 free seats.");
        } else if (numberOfGuests <= 5) {
            System.out.println("The boat for 5 ran out, there are still 5 free seats.");
        } else if (numberOfGuests <= 7) {
            System.out.println("The boat for 5 and the boat for 2 ran out, there are still 3 free seats.");
        } else if (numberOfGuests == 8) {
            System.out.println("The boat for 5 and the boat for 3 ran out, there are still 2 free seats.");
        } else {
            System.out.println("All of the boats ran out, there isn't any free seat.");
        }

        if (linedUp == 1) {
            System.out.println("There is a person waiting on the shore");
        } else if (linedUp > 1) {
            System.out.println("There are " + linedUp + " persons waiting on the shore.");
        }
    }
}


