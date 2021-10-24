package statements;

public class Investment {

    private double cost = 0.3;
    private int fund;
    private int interestRate;
    private boolean active;

    public Investment(int fund, int interestRate) {
        this.fund = fund;
        this.interestRate = interestRate;
        this.active = true;
    }

    public int getFund() {
        return fund;
    }

    public double getYield(int days) {
        return (this.fund * this.interestRate / 100.0 / 365.0 * days);
    }

    public double close (int days) {
        double payment = (this.active ? getYield(days) + fund - ((getYield(days) + fund) * cost/100) : 0.0);
        this.active = false;
        return payment;
    }
}
