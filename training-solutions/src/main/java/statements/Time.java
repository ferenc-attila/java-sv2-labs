package statements;

public class Time {

    int hours;
    int minutes;
    int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
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

    public int getInMinutes() {
        int inMinutes = (getHours() * 60) + getMinutes();
        return inMinutes;
    }

    public int getInSeconds() {
        int inSeconds = (getHours() * 3600) + getInMinutes() * 60 + getSeconds();
        return inSeconds;
    }

    public boolean earlierThan (Time firstTime, Time secondTime) {
        boolean earlierThan = firstTime.getInSeconds() < secondTime.getInSeconds();
        return earlierThan;
    }

    public String toString (Time time) {
        String timeString = time.hours + ":" + time.minutes + ":" + time.seconds;
        return timeString;
    }
}
