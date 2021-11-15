package introexceptionfirstexception;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérem adja meg a nevét!");
        String name = scanner.nextLine();
        System.out.println("Kérem adja meg, melyik filmre szeretne jegyet venni!");
        String movieTitle = scanner.nextLine();
        System.out.println("Kérem adja meg, hogy hány darab jegyet kér!");
        int numberOfTickets = scanner.nextInt();
        System.out.println("Kérem, adja meg, hogy melyik sorba kéri a jegyeket!");
        int numberOfRow = scanner.nextInt();

        StringBuilder feedback = new StringBuilder();

        feedback.append("A mozijegy.hu rendszerben vásárolt jegyek adatai a következők:\n" +
                "Vásárló neve: " +
                name +
                "\nFilm címe: " +
                movieTitle +
                "\nLefoglalt helyek: ");

        for (int i = 1; i <= numberOfTickets; i++) {
            if (i < numberOfTickets) {
                feedback.append(numberOfRow).append(". sor ").append(i).append(". szék");
                feedback.append(", ");
            } else {
                feedback.append(numberOfRow).append(". sor ").append(i).append(". szék");
            }
        }
        feedback.append("\nJó szórakozást!");

        System.out.println(feedback);
    }
}
