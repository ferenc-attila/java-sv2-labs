package datenewtypes;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Rendezvous {

    private LocalTime time;

    public Rendezvous(int hours, int minutes) {
        validateTime(hours, minutes);
        this.time = LocalTime.of(hours, minutes);
    }

    public Rendezvous(String timeString, String pattern) {
        this.time = parseTimeString(timeString, pattern);
    }

    public int countMinutesLeft(LocalTime time) {
        if (time.isAfter(this.time)) {
            throw new MissedOpportunityException("Too late!");
        }
        return (int) (ChronoUnit.MINUTES.between(time, this.time));
    }

    public void pushLater(int hours, int minutes) {
        validatePlusMinusTime(hours, minutes);
        this.time = this.time.plusHours(hours).plusMinutes(minutes);
    }

    public void pullEarlier(int hours, int minutes) {
        validatePlusMinusTime(hours, minutes);
        this.time = this.time.minusHours(hours).minusMinutes(minutes);
    }

    public String toString(String pattern) {
        return this.time.format(getDateTimeFormatter(pattern));
    }

    public LocalTime getTime() {
        return time;
    }

    private void validatePlusMinusTime(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            throw new IllegalArgumentException("Invalid values!");
        }
    }

    private void validateTime(int hours, int minutes) {
        if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Invalid time values: " + hours + ", " + minutes);
        }
    }

    private LocalTime parseTimeString(String timeString, String pattern) {
        if (timeString.isBlank()) {
            throw new IllegalArgumentException("Illegal time string: " + timeString);
        }
        DateTimeFormatter formatter = getDateTimeFormatter(pattern);
        try {
            return LocalTime.parse(timeString, formatter);
        } catch (DateTimeParseException dpe) {
            throw new IllegalArgumentException("Illegal time string: " + timeString);
        }
    }

    private DateTimeFormatter getDateTimeFormatter(String pattern) {
        if (pattern.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string");
        }
        return DateTimeFormatter.ofPattern(pattern);
    }
}
