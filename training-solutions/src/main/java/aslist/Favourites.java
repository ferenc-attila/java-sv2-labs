package aslist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Favourites {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> favouriteThings = new ArrayList<>();

        System.out.println("Enter your favourite animal:");
        String thing = scanner.nextLine();
        favouriteThings.add(thing);
        System.out.println("Enter your favourite color:");
        thing = scanner.nextLine();
        favouriteThings.add(thing);
        System.out.println("Enter your favourite movie:");
        thing = scanner.nextLine();
        favouriteThings.add(thing);
        System.out.println("Enter your favourite actor:");
        thing = scanner.nextLine();
        favouriteThings.add(thing);
        System.out.println("Enter your favourite city:");
        thing = scanner.nextLine();
        favouriteThings.add(thing);

        System.out.println("Your list contains " + favouriteThings.size() + " element");
        System.out.println("The list of your favourite things contains the elements below:");
        System.out.println(favouriteThings);
    }
}
