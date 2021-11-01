package control;

public class ControlSelectionMain {

    public boolean isEven(int x) {
        boolean even;
        if ((x % 2) == 0) {
            even = true;
        } else {
            even = false;
        }
        return even;
    }

    public String getTypeOfDayWithSwitchStatement (String dayOfWeekArg) {
        String typeOfDay;
        switch (dayOfWeekArg) {
            case "Monday":
                typeOfDay = "Start of work week";
                break;
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
                typeOfDay = "Midweek";
                break;
            case "Friday":
                typeOfDay = "End of work week";
                break;
            case "Saturday":
            case "Sunday":
                typeOfDay = "Weekend";
                break;
            default:
                throw new IllegalArgumentException("Unknown day");
        }
        return typeOfDay;
    }

    public static void main(String[] args) {
        System.out.println((new ControlSelectionMain().isEven(1)));
        System.out.println(new ControlSelectionMain().getTypeOfDayWithSwitchStatement("aaa"));
    }
}
