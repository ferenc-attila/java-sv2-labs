package classstructureintegrate;

import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("To open an account, please give the information below:");
        System.out.println("Owner's name:");
        String owner = scanner.nextLine();
        System.out.println("Account's number");
        String accountNumber = scanner.nextLine();
        System.out.println("Balance:");
        int balance = scanner.nextInt();
        scanner.nextLine();

        BankAccount account = new BankAccount(owner, accountNumber, balance);

        System.out.println("Your account's informations are:");
        System.out.println(account.getInfo());

        System.out.println("Amount to be paid in:");
        int amount = scanner.nextInt();
        scanner.nextLine();

        account.deposit (amount);

        System.out.println("After deposit, your account's informations are:");
        System.out.println(account.getInfo());

        System.out.println("Amount, you withdraw:");
        amount = scanner.nextInt();
        scanner.nextLine();

        account.withdraw(amount);

        System.out.println("After withdraw your account's informations are:");
        System.out.println(account.getInfo());

    }
}
