package introexceptionwritefile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Birthday {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n*** Születésnapok nyilvántratása ***\n");

        System.out.println("Hány adatot szeretnél rögzíteni?");
        int numberOfElements;
        try {
            numberOfElements = scanner.nextInt();
            scanner.nextLine();
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Not a valid number!", nfe);
        }

        List<String> birthdays = new ArrayList<>();
        if (numberOfElements < 1) {
            throw new IllegalArgumentException("Not a positive number!");
        } else {
            for (int i = 0; i < numberOfElements; i++) {
                System.out.println("Add meg a rögzíteni kívánt személy nevét!");
                String name = scanner.nextLine();
                System.out.println(("Add meg a születésnapját!"));
                String dateOfBirthString = scanner.nextLine();
                birthdays.add(name + ";" + dateOfBirthString);
            }
        }

        Path path = Paths.get("src/main/resources/birthdays.csv");
        try {
            Files.write(path, birthdays);
            System.out.println("A " + path + " fájlba írtam ki az eredményt");
        } catch (IOException ioe) {
            System.out.println("Unable to write file!");
            ioe.printStackTrace();
        }
    }
}
