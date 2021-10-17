package statements;

public class Investment {

    double cost = 0.3;
    int fund;
    int interestRate;
    boolean active;

    public Investment(int fund, int interestRate) {
        this.fund = fund;
        this.interestRate = interestRate;
        this.active = true;
    }

    public int getFund() {
        return fund;
    }

    public double getYield(int days) {
        double yield = ((getFund() * (this.interestRate/100)) / 365) * days;
        return yield;
    }

    public double close (int days) {
        double payment = (this.active == true ? getYield(days) + getFund() - ((getYield(days) + getFund()) * cost) : 0.0);
        this.active = false;
        return payment;
    }


}
