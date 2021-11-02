package controliteration.day;

import java.util.ArrayList;
import java.util.List;

public class Day {

    List<Hour> hoursOfDay = new ArrayList<>();

    public void addHour(Hour hour) {
        hoursOfDay.add(hour);
    }

    public List<Hour> getHoursOfDay() {
        return hoursOfDay;
    }

    public void setDayPeriod() {
        for (Hour hour : hoursOfDay) {
            if ((hour.getHourNumber() >= 6) && (hour.getHourNumber() <= 22)) {
                hour.setPeriod(DayPeriod.DAYTIME);
            } else {
                hour.setPeriod(DayPeriod.NIGHTTIME);
            }
        }
    }
}
