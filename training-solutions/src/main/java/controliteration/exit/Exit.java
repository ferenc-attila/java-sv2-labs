package controliteration.exit;

import java.util.Scanner;

public class Exit {

    public static void main(String[] args) {

        String exit;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Az ügyfélszolgálat menüje jelenleg nem elérhető.");
            System.out.println("Kilépés az x billentyű, majd az Enter megnyomásával lehetslges.");
            exit = scanner.nextLine();
        } while (!"x".equalsIgnoreCase(exit));
    }
}
