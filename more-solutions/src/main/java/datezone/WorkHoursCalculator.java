package datezone;

import java.time.Duration;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class WorkHoursCalculator {

    private int startYear;
    private Month startMonth;
    private int startDay;
    private int startHour;
    private ZoneId zone;

    public WorkHoursCalculator(int startYear, Month startMonth, int startDay, int startHour, ZoneId zone) {
        this.startYear = startYear;
        validateMonth(startMonth);
        this.startMonth = startMonth;
        this.startDay = startDay;
        this.startHour = startHour;
        validateZone(zone);
        this.zone = zone;
    }

    private void validateZone(ZoneId zone) {
        if (zone == null) {
            throw new NullPointerException("Zone cannot be null!");
        }
    }

    private void validateMonth(Month startMonth) {
        if (startMonth == null) {
            throw new NullPointerException("Month cannot be null!");
        }
    }

    public long calculateHours(int year, Month month, int day, int hour) {
        Duration duration = Duration.between(getStartDateTime(), createZoneDateTime(year, month, day, hour));
        return duration.toHours();
    }

    public ZonedDateTime getStartDateTime() {
        return createZoneDateTime(startYear, startMonth, startDay, startHour);
    }

    private ZonedDateTime createZoneDateTime(int year, Month month, int day, int hour) {
        return ZonedDateTime.of(year, month.getValue(), day, hour, 0, 0, 0, this.zone);
    }
}
