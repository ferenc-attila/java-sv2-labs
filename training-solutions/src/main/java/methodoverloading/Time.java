package methodoverloading;

public class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public boolean isEqual(Time time) {
        return (this.timeInSeconds() == time.timeInSeconds());
    }

    public boolean isEqual(int hours, int minutes, int seconds) {
        return isEqual(new Time(hours, minutes, seconds));
    }

    public boolean isEarlier(Time time) {
        return (this.timeInSeconds() < time.timeInSeconds());
    }

    public boolean isEarlier(int hours, int minutes, int seconds) {
        return isEarlier(new Time(hours, minutes, seconds));
    }

    private int timeInSeconds() {
        return (this.hours * 3600) + (this.minutes) * 60 + getSeconds();
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}
