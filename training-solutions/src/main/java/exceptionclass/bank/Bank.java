package exceptionclass.bank;

import java.util.List;

public class Bank {

    private List<Account> accounts;

    public Bank(List<Account> accounts) {
        validateAccounts(accounts);
        this.accounts = accounts;
    }

    public void payment (String accountNumber, double amount) {
        Account account = findAccountByNumber(accountNumber);
        account.subtract(amount);
    }

    public void deposit (String accountNumber, double amount) {
        Account account = findAccountByNumber(accountNumber);
        account.deposit(amount);
    }

    private void validateAccounts(List<Account> accounts) {
        if (accounts == null || accounts.isEmpty()) {
            throw new IllegalArgumentException("Account list should not be null!");
        }
    }

    private Account findAccountByNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new InvalidAccountNumberBankOperationException("Invalid account number!");
        }
        for (Account actual : accounts) {
            if (accountNumber.equals(actual.getAccountNumber())) {
                return actual;
            }
        }
        throw new InvalidAccountNumberBankOperationException("Invalid account number!");
    }
}
