package initializer;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {

    private static final List<Rate> ACTUAL_RATES = new ArrayList<>();
    private long balance;

    public CreditCard(long balance) {
        this.balance = balance;
    }

    public CreditCard(long balance, Currency currency, List<Rate> rates) {
        ACTUAL_RATES.addAll(rates);
        this.balance = Math.round(balance * getConversionRate(currency));
    }

    public boolean payment(long amount, Currency currency) {
        long paymentAmount = Math.round(amount * getConversionRate(currency));
        if (paymentAmount <= balance) {
            balance -= paymentAmount;
            return true;
        }
        return false;
    }

    public boolean payment(long amount) {
        return payment(amount, Currency.HUF);
    }

    public long getBalance() {
        return balance;
    }

    private double getConversionRate(Currency currency) {
        double conversionRate = 1.0;
        for (Rate rate : ACTUAL_RATES) {
            if (rate.getCurrency() == currency) {
                conversionRate = rate.getConversionFactor();
            }
        }
        return conversionRate;
    }
}
