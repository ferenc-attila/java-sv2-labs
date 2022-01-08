package exceptionclass.course;

public class SimpleTime {

    private int hour;
    private int minute;

    public SimpleTime(String hour, String minute) {
        validateHours(hour);
        validateHours(minute);
        this.hour = Integer.parseInt(hour);
        this.minute = Integer.parseInt(minute);
    }

    public SimpleTime(int hour, int minute) {
        validateHours(hour);
        validateMinutes(minute);
        this.hour = hour;
        this.minute = minute;
    }

    public SimpleTime(String timeString) {
        validateTime(timeString);
        String[] timeValues = timeString.split(":");
        validateHours(timeValues[0]);
        this.hour = Integer.parseInt(timeValues[0]);
        validateMinutes(timeValues[1]);
        this.minute = Integer.parseInt(timeValues[1]);
    }

    @Override
    public String toString() {
        return createHourString() + ":" + createMinuteString();
    }

    private String createHourString() {
        String hourString;
        if (hour < 10) {
            hourString = "0" + hour;
        } else {
            hourString = Integer.toString(hour);
        }
        return hourString;
    }

    private String createMinuteString() {
        String minuteString;
        if (minute < 10) {
            minuteString = "0" + minute;
        } else {
            minuteString = Integer.toString(minute);
        }
        return minuteString;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    private void validateTime(String timeString) {
        if (timeString == null || timeString.isBlank()) {
            throw new InvalidTimeException("Time is null");
        }
        if (timeString.length() != 5 || timeString.indexOf(":") != 2) {
            throw new InvalidTimeException("Time is not hh:mm");
        }
        char[] chars = timeString.toCharArray();
        for (int i = 0; i < timeString.length() && i != 2; i++) {
            if (!(Character.isDigit(chars[i]))) {
                throw new InvalidTimeException("Time is not hh:mm");
            }
        }
    }

    private void validateHours(String hourString) {
        int hourValue;
        try {
            hourValue = Integer.parseInt(hourString);
        } catch (NumberFormatException nfe) {
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
        validateHours(hourValue);
    }

    private void validateHours(int hours) {
        if (hours < 0 || hours > 23) {
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
    }

    private void validateMinutes(String minuteString) {
        int minuteValue;
        try {
            minuteValue = Integer.parseInt(minuteString);
        } catch (NumberFormatException nfe) {
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
        validateMinutes(minuteValue);
    }

    private void validateMinutes(int minutes) {
        if (minutes < 0 || minutes > 59) {
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
    }
}
