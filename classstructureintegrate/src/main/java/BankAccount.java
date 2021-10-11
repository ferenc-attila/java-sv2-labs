public class BankAccount {

    String accountNumber;
    String owner;
    int balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }

    public BankAccount(String owner, String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    /*deposit(amount int),
    withdraw(amount int),
    getInfo(String "Tóth Kálmán (10073217-12000098-67341590): 103400 Ft")
    */

    public void deposit (int amount) {
        this.balance = getBalance() + amount;
    }

    public void withdraw(int amount) {
        this.balance = getBalance() - amount;
    }

    public void getInfo() {
        System.out.println(getOwner() + " (" + getAccountNumber() + "): " + getBalance() + " Ft");
    }

}
