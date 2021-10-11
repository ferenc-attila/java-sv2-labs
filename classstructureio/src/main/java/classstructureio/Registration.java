package classstructureio;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("### Regisztráció ###");
        System.out.println("Adja meg a nevét!");
        String name = scanner.nextLine();
        System.out.println("Adja meg az e-mail címét!");
        String email = scanner.nextLine();

        System.out.println("Ön az alábbi adatokkal regisztrált:");
        System.out.println("Név: " + name + "; e-mail: " + email);

    }
}
