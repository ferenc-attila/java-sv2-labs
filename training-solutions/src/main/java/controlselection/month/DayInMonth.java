package controlselection.month;

public class DayInMonth {

    public int dayInMonth (int year, String nameOfMonth){
        int dayInMonth;
        nameOfMonth = nameOfMonth.toLowerCase();
        switch (nameOfMonth) {
            case "január":
            case "március":
            case "május":
            case "július":
            case "augusztus":
            case "október":
            case "december":
                dayInMonth = 31;
                break;
            case "február":
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    dayInMonth = 29;
                } else {
                    dayInMonth = 28;
                }
                break;
            case "április":
            case "június":
            case "szeptember":
            case "november":
                dayInMonth = 30;
                break;
            default:
                dayInMonth = 0;
                break;
        }
        return dayInMonth;
    }
}
