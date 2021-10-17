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
        double yield = this.getFund() * this.interestRate / 100.0 / 365.0 * days; //The division works correctly only with double (e.g. 100.0 instead of 100). Why?
        return yield;
    }

    public double close (int days) {
        double payment = (this.active == true ? getYield(days) + getFund() - ((getYield(days) + getFund()) * cost/100) : 0.0); // The division of cost works correctly with integer also. Why?
        this.active = false;
        return payment;
    }

}
