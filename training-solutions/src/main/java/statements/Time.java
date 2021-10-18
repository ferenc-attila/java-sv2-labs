package statements;

public class Time {

    private int hours;
    private int minutes;
    private int seconds;

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

    public boolean earlierThan (Time anotherTime) {
        boolean earlierThan = this.getInSeconds() < anotherTime.getInSeconds();
        return earlierThan;
    }

    public String toString () {
        String timeString = this.hours + ":" + this.minutes + ":" + this.seconds;
        return timeString;
    }
}
