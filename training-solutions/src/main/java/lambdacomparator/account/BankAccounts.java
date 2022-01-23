package lambdacomparator.account;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class BankAccounts {

    private List<BankAccount> accounts;

    public BankAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public List<BankAccount> listBankAccountsByAccountNumber() {
        List<BankAccount> accountsByAccountNumber = new ArrayList<>(accounts);
        accountsByAccountNumber.sort(Comparator.naturalOrder());
        return accountsByAccountNumber;
    }

    public List<BankAccount> listBankAccountsByBalance() {
        List<BankAccount> accountsByBalanceAbs = new ArrayList<>(accounts);
        accountsByBalanceAbs.sort(Comparator.comparing(
                account -> Math.abs(account.getBalance())));
        return accountsByBalanceAbs;
    }

    public List<BankAccount> listBankAccountsByBalanceDesc() {
        List<BankAccount> accountsByBalance = new ArrayList<>(accounts);
        accountsByBalance.sort(Comparator.comparing(BankAccount::getBalance).reversed());
        return accountsByBalance;
    }

    public List<BankAccount> listBankAccountsByNameThenAccountNumber() {
        List<BankAccount> accountsByNameThenAccountNumber = new ArrayList<>(accounts);
        Collator collator = Collator.getInstance(new Locale("hu", "HU"));
        accountsByNameThenAccountNumber.sort(Comparator.comparing(BankAccount::getNameOfOwner,
                        Comparator.nullsFirst(collator))
                .thenComparing(Comparator.naturalOrder()));
        return accountsByNameThenAccountNumber;
    }

    public List<BankAccount> getAccounts() {
        return List.copyOf(accounts);
    }
}
