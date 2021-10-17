package statements;

import java.util.Scanner;

public class InvestmentMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the fund of the new investment:");
        int fund = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the interest rate of the new investment:");
        int interestRate = scanner.nextInt();
        scanner.nextLine();

        Investment investment = new Investment(fund, interestRate);

        System.out.println("How many days do you want to calculate the yield?");
        int yieldDays = scanner.nextInt();
        scanner.nextLine();

        System.out.println("In how many days do you want to close the investment?");
        int closeDays = scanner.nextInt();
        scanner.nextLine();

        System.out.println("In how many days do you want to close the investment second time?");
        int falseCloseDays = scanner.nextInt();
        scanner.nextLine();

        System.out.println("The amount of investment:");
        System.out.println(investment.getFund());
        System.out.println("The yearly interest rate of the investment:");
        System.out.println(investment.interestRate + "%");
        System.out.println("Fund: " + investment.getFund());

        System.out.println("Yield for " + yieldDays + " days: " + investment.getYield(yieldDays));
        System.out.println("Payment after " + closeDays + " days: " + investment.close(closeDays));
        System.out.println("Payment after " + falseCloseDays + " days: " + investment.close(falseCloseDays));
    }

}