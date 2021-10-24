package packages.namemain;

import packages.firstname.FirstName;
import packages.lastname.LastName;
import packages.prefix.Prefix;

import java.util.Scanner;

public class NameMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name's prefix:");
        String prefix = scanner.nextLine();
        System.out.println("Enter your first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last name:");
        String lastName = scanner.nextLine();

        Prefix pre = new Prefix(prefix);
        FirstName first = new FirstName(firstName);
        LastName last = new LastName(lastName);

        String completeName = pre.getPre() + " " + first.getFirst() + " " + last.getLast();
        System.out.println(completeName);
    }
}
