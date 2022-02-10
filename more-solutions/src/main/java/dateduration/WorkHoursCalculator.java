package dateduration;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class WorkHoursCalculator {

    private List<Duration> durations = new ArrayList<>();

    public void addWorkTime(Duration duration) {
        durations.add(duration);
    }

    public void addWorkTime(String durationString) {
       try {
           durations.add(Duration.parse(durationString));
       } catch (DateTimeParseException dtpe) {
           throw new IllegalArgumentException("Cannot read duration string: " + durationString + "!", dtpe);
       }
    }

    public void addWorkTime(LocalTime from, LocalTime to) {
        durations.add(Duration.between(from, to));
    }

    public void addWorkTime(String from, String to, String pattern) {
        validateString(from);
        validateString(to);
        validateString(pattern);
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            LocalTime start = LocalTime.parse(from, formatter);
            LocalTime end = LocalTime.parse(to, formatter);
            addWorkTime(start, end);
        } catch (IllegalArgumentException | DateTimeParseException e){
            throw new IllegalArgumentException("Invalid parameter!", e);
        }
    }

    public int calculateWorkHours() {
        return (int) getWorkDuration().toHours();
    }

    public Duration getWorkDuration() {
        Duration d = Duration.ofMinutes(0);
        for (Duration actual : durations) {
            d = d.plus(actual);
        }
        return d;
    }

    public String toString() {
        return getWorkDuration().toString();
    }

    private void validateString (String string) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException("String parameter cannot be null or empty!");
        }
    }
}
