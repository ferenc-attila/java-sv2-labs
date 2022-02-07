package datenewtypes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateOfBirth {

    private LocalDate date;
    private String pattern;
    private Locale locale;

    public DateOfBirth(int year, int month, int day) {
        LocalDate parsedDate = LocalDate.of(year, month, day);
        validateDateOfBirth(parsedDate);
        this.date = parsedDate;
    }

    public DateOfBirth(String dateString) {
        LocalDate parsedDate = LocalDate.parse(dateString);
        validateDateOfBirth(parsedDate);
        this.date = parsedDate;
    }

    public DateOfBirth(String date, String pattern) {
        this(date);
        validatePattern(pattern);
        this.pattern = pattern;
    }

    public DateOfBirth(String date, String pattern, Locale locale) {
        this(date, pattern);
        validateLocale(locale);
        this.locale = locale;
    }

    public int countDaysSinceBirth(LocalDate date) {
        if (this.date.isAfter(date)) {
            throw new IllegalStateException("Birthdate is in the future");
        }
        return (int) (ChronoUnit.DAYS.between(this.date, date));
    }

    public int countDaysBetween(DateOfBirth anotherDateOfBirth) {
        long value = ChronoUnit.DAYS.between(this.date, anotherDateOfBirth.getDate());
        if (date.isBefore(anotherDateOfBirth.getDate())) {
            return (int) value;
        } else {
            return (int) (value * -1);
        }
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        validateLocale(locale);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE", locale);
        return date.format(formatter);
    }

    public String findDayOfWeekForBirthDate(Locale locale, LocalDate later) {
        validateLocale(locale);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE", locale);
        return later.format(formatter);
    }

    public String findBirthDayOfWeekLater(int year) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE");
        return date.plusYears(year).format(formatter);
    }

    public boolean isWeekDay() {
        return date.getDayOfWeek().getValue() < 5;
    }

    public boolean wasItAtLeapYear() {
        return date.isLeapYear();
    }

    public String toString(String pattern) {
        validatePattern(pattern);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    private void validateDateOfBirth(LocalDate date) {
        if (date.isAfter(LocalDate.now())) {
            throw new IllegalStateException("Birthdate is in the future");
        }
    }

    private void validateLocale(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null");
        }
    }

    private void validatePattern(String pattern) {
        if (pattern.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string");
        }
    }

    public LocalDate getDate() {
        return date;
    }
}
