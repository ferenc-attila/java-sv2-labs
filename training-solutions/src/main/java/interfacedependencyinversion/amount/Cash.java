package interfacedependencyinversion.amount;

public class Cash implements Payable{

    @Override
    public int getPayableAmount(int amount) {
        String amountString = ((Integer) amount).toString();
        String lastDigit = amountString.substring(amountString.length() - 1);
        switch (lastDigit) {
            case "1", "2":
                return (amount /  10) * 10;
            case "3", "4", "6", "7":
                return (amount / 10) * 10 + 5;
            case "8", "9":
                return (amount / 10) * 10 + 10;
            default:
                return amount;
        }
    }
}
