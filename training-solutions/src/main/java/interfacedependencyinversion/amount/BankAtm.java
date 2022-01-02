package interfacedependencyinversion.amount;

public class BankAtm implements Payable {

    @Override
    public int getPayableAmount(int amount) {
        String amountString = ((Integer) amount).toString();
        String lastThreeDigit = amountString.substring(amountString.length() - 3);
        if (lastThreeDigit.equals("000")) {
            return amount;
        }
        return (amount / 1000 + 1) * 1000;
    }
}
