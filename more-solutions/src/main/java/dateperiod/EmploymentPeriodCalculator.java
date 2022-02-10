package dateperiod;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EmploymentPeriodCalculator {

    private List<Period> periods = new ArrayList<>();

    public void addEmploymentPeriod(Period period) {
        periods.add(fullyNormalized(period));
    }

    public Period sumEmploymentPeriods() {
        Period p = Period.ofDays(0);
        periods.forEach(p::plus);
        return fullyNormalized(p);
    }

    public Period modifyByDays(Period period, int days) {
        Period p = period.plusDays(days);
        return fullyNormalized(p);
    }

    public Period getPeriodBetweenDates(LocalDate fromDate, LocalDate toDate) {
        validateDate(fromDate);
        validateDate(toDate);
        Period p = Period.between(fromDate, toDate);
        return fullyNormalized(p);
    }

    public Period getPeriodBetweenDates(String fromDate, String toDate, String pattern) {
        validateString(fromDate);
        validateString(toDate);
        validateString(pattern);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate from = LocalDate.parse(fromDate, formatter);
        LocalDate to = LocalDate.parse(toDate, formatter);
        return getPeriodBetweenDates(from, to);
    }

    public int calculateTotalDays(Period period) {
        return (int)(period.getDays() + period.toTotalMonths() * 30);
    }

    private Period fullyNormalized(Period period) {
        int totalDays = calculateTotalDays(period);
        int years = totalDays / 365;
        int months = (totalDays - (years * 365)) / 30;
        int days = totalDays - years * 365 - months * 30;
        return Period.of(years, months, days);
    }

    private void validateString (String string) {
        if (string.isBlank()) {
            throw new IllegalArgumentException("String parameter cannot be null or empty!");
        }
    }

    private void validateDate (LocalDate date) {
        if (date == null) {
            throw new NullPointerException("Date parameter cannot be null!");
        }
    }
}
