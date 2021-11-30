package defaultconstructor.date;

public class SimpleDate {

    private int year;
    private int month;
    private int day;

    public void setDate(int year, int month, int day) {
        if (isCorrect(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        } else {
            throw new IllegalArgumentException("One or more given parameter cannot be applied! " + year + ", " + month + ", " + day);
        }
    }

    private boolean isCorrect(int year, int month, int day) {
        return year >= 1900 && month >= 1 && month <= 12 && day >= 1 && day <= calculateMonthLength(year, month);
    }

    private boolean isLeapYear(int year) {
        return ((year % 100 == 0 && year % 400 == 0) || year % 4 == 0);
    }

    private int calculateMonthLength(int year, int month) {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                return 31;
            case 4, 6, 9, 11:
                return 30;
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                } else return 28;
            default:
                throw new IllegalArgumentException("Month must be between 1 and 12!");
        }
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
