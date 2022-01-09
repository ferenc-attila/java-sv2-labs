package exceptionclass.bank;

public class Account {

    private final String accountNumber;
    private double balance;
    private double maxSubtract;

    public Account(String accountNumber, double balance) {
        checkAccountNumber(accountNumber);
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.maxSubtract = 100000;
    }

    private void checkAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number should not be null!");
        }
    }

    public double subtract(double amount) {
        validateAmount(amount);
        validateAmountAgainstBalance(amount);
        balance -= amount;
        return balance;
    }

    public double deposit(double amount) {
        validateAmount(amount);
        balance += amount;
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getMaxSubtract() {
        return maxSubtract;
    }

    public void setMaxSubtract(double maxSubtract) {
        validateAmount(maxSubtract);
        this.maxSubtract = maxSubtract;
    }

    private void validateAmount(double amount) {
        if (amount <= 0) {
            throw new InvalidAmountBankOperationException("Invalid amount!");
        }
    }

    private void validateAmountAgainstBalance(double amount) {
        if (amount > balance) {
            throw new LowBalanceBankOperationException("Low balance!");
        }
    }
}
