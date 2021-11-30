package staticattrmeth.bank;

public class BankTransaction {

    private static final long MIN_TRANSACTION_VALUE = 1;
    private static final long MAX_TRANSACTION_VALUE = 10_000_000;
    private static long countOfTransactions;
    private static long sumOfTransactions;
    private static long currentMinValue;
    private static long currentMaxValue;
    private long transactionValue;

    public BankTransaction(long transactionValue) {
        if (transactionValue < MIN_TRANSACTION_VALUE || transactionValue > MAX_TRANSACTION_VALUE) {
            throw new IllegalArgumentException("Invalid trasaction value!;");
        }
        this.transactionValue = transactionValue;
        countOfTransactions++;
        sumOfTransactions += transactionValue;
        if (transactionValue < currentMinValue) {
            currentMinValue = transactionValue;
        }
        if (transactionValue > currentMaxValue) {
            currentMaxValue = transactionValue;
        }
    }

    public static void initTheDay() {
        countOfTransactions = 0;
        sumOfTransactions = 0;
        currentMinValue = Long.MAX_VALUE;
        currentMaxValue = Long.MIN_VALUE;
    }

    public static long getAverageOfTransaction() {
        return countOfTransactions == 0 ? 0 : sumOfTransactions / countOfTransactions;
    }

    public static long getCurrentMinValue() {
        return countOfTransactions == 0 ? 0 : currentMinValue;
    }

    public static long getCurrentMaxValue() {
        return countOfTransactions == 0 ? 0 : currentMaxValue;
    }

    public static long getSumOfTransactions() {
        return countOfTransactions == 0 ? 0 : sumOfTransactions;
    }

    public long getTransactionValue() {
        return this.transactionValue;
    }
}
