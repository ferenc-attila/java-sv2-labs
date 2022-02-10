package datezone;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FlightInfo {

    private ZonedDateTime date;

    public FlightInfo (String dateString, String pattern, Locale locale, ZoneId zone) {
        validateString(dateString);
        validateString(pattern);
        validateLocale(locale);
        validateZone(zone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, locale);
        this.date = ZonedDateTime.of(LocalDateTime.parse(dateString, formatter), zone);
    }

    public ZonedDateTime getArrivalDateTime(ZoneId zone, int flightHours, int flightMinutes) {
        return date.plusHours(flightHours).plusMinutes(flightMinutes).withZoneSameInstant(zone);
    }

    private void validateZone(ZoneId zone) {
        if (zone == null) {
            throw new NullPointerException("Zone cannot be null!");
        }
    }

    private void validateLocale(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Locale cannot be null!");
        }
    }

    private void validateString(String dateString) {
        if (dateString.isBlank()) {
            throw new IllegalArgumentException("String cannot be null or empty!");
        }
    }
}
