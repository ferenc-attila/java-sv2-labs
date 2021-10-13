package classstructureintegrate;

public class BankAccount {

    private String accountNumber;
    private String owner;
    private int balance;

    public BankAccount(String owner, String accountNumber, int balance) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(int amount) {
        this.balance = this.balance + amount;
    }

    public void withdraw (int amount) {
        this.balance = this.balance - amount;
    }

    public String getInfo() {
        String info = this.owner + " (" + this.accountNumber + "): " + this.balance + "Ft";
        return info;
    }

}
