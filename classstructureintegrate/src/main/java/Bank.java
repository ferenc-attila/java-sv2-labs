import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérem, adja meg a nevét!");
        String name = scanner.nextLine();
        System.out.println("Kérem, adja meg a bankszámla számát!");
        String accountNumber = scanner.nextLine();
        System.out.println("Kérem, adja meg a számlán lévő összeget!");
        int balance = scanner.nextInt();
        scanner.nextLine();

        BankAccount account = new BankAccount(name, accountNumber, balance);

        System.out.println("A bankszámlája az alábbi adatokkal készült el:");
        account.getInfo();

        System.out.println("Kérem, adja meg a befizetni kívánt összeget:");
        int amount = scanner.nextInt();
        scanner.nextLine();

        account.deposit(amount);
        System.out.println("Az ön új egyenlege " + account.getBalance() + " Ft.");

        System.out.println("Kérem, adja meg a felvenni kívánt összeget:");
        amount = scanner.nextInt();
        scanner.nextLine();

        account.withdraw(amount);
        System.out.println("Az ön új egyenlege " + account.getBalance() + " Ft.");

    }
}
